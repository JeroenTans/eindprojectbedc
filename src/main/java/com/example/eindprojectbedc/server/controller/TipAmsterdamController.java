package com.example.eindprojectbedc.server.controller;
import com.example.eindprojectbedc.server.Service.FileStorageService;
import com.example.eindprojectbedc.server.Service.TipAmsterdamService;
import com.example.eindprojectbedc.server.model.TipAmsterdam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/tips")
public class TipAmsterdamController {

    @Autowired
    TipAmsterdamService tipAmsterdamService;

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping
    public List<TipAmsterdam> getAllTipsAmsterdam() {
        return tipAmsterdamService.getAllTipsAmsterdam();
    }

    @GetMapping("{id}/picturePath")
    public ResponseEntity downloadFile(@PathVariable("id") Long id) {
        Resource resource = tipAmsterdamService.downloadFile(id);
        String fileName = tipAmsterdamService.getTipAmsterdam(id).getPicturePath();
        String mediaType = "application/octet-stream";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mediaType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = \"" + fileName + "\"")
                .body(resource);
    }

    @GetMapping("/{id}")
    public TipAmsterdam getTipAmsterdam(@PathVariable("id") Long id) {
        return tipAmsterdamService.getTipAmsterdam(id);
    }

    @GetMapping("/tip/{id}")
    public ResponseEntity<Object> getTipAmsterdamById(@PathVariable("id") Long id) {
        Optional<TipAmsterdam> tipAmsterdam = tipAmsterdamService.getTipAmsterdamById(id);
        return new ResponseEntity<>(tipAmsterdam, HttpStatus.OK);
    }

    @GetMapping("getSendTips/{username}")
    public List<TipAmsterdam> getAllSendTips(@PathVariable("username") String username){return tipAmsterdamService.getAllSendTips(username);}

    @GetMapping("getAllTradedTips/{username}")
    public List<TipAmsterdam> getAllTradedTips(@PathVariable("username") String username){
        return tipAmsterdamService.getAllTradedTips(username);
    }

    @GetMapping("publicTip")
    public List<Object> getAllPublicTipsAmsterdam() {
        return tipAmsterdamService.getAllPublicTipsAmsterdam();
    }

    @GetMapping("privateTip")
    public List<Object> getAllPrivateTipsAmsterdam() {
        return tipAmsterdamService.getAllPrivateTipsAmsterdam();
    }

    @GetMapping("standardTip")
    public List<Object> getAllStandardTipsAmsterdam() {
        return tipAmsterdamService.getAllStandardTipsAmsterdam();
    }

    @GetMapping("{username}/privateTip")
    public List<Object> getAllPrivateTipsByUsername(@PathVariable("username") String username) {
        return tipAmsterdamService.getAllPrivateTipsAmsterdamByUsername(username);
    }

    @GetMapping("groupTips/{groupName}")
    public List<TipAmsterdam> getAllGroupTipsByGroupName (@PathVariable("groupName") String groupName){
        return tipAmsterdamService.getAllGroupTips(groupName);
    }

    @GetMapping("{username}/publicTip")
    public List<Object> getAllPublicTipsByUsername(@PathVariable("username") String username) {
        return tipAmsterdamService.getAllPublicTipsAmsterdamByUsername(username);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Object> deleteTipAmsterdamById(@PathVariable("id") Long id) throws IOException {
        String fileName = getTipAmsterdam(id).getPicturePath();
        tipAmsterdamService.deleteTipAmsterdam(id);
        fileStorageService.deleteFile(fileName);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("addUserAndGetTipById/{username}/{id}")
    public TipAmsterdam addUserToTipAmsterdam(@PathVariable("username") String username, @PathVariable("id") Long id){
        return tipAmsterdamService.addUsernameToTipAmsterdam(id, username);
    }

    @PostMapping(value = "/tip_upload")
    public ResponseEntity<Object> addTip(@RequestParam String address,
                                         @RequestParam String explanation,
                                         @RequestParam String username,
                                         @RequestParam String groupName,
                                         @RequestParam boolean privateTip,
                                         @RequestParam boolean publicTip,
                                         @RequestParam boolean standardTip,
                                         @RequestParam boolean sendTip,
                                         @RequestParam boolean groupTip,
                                         @RequestParam MultipartFile picturePath) {
        try {
            fileStorageService.uploadFile(picturePath);

            TipAmsterdam tipAmsterdam = new TipAmsterdam();
            tipAmsterdam.setAddress(address);
            tipAmsterdam.setExplanation(explanation);
            tipAmsterdam.setPublicTip(publicTip);
            tipAmsterdam.setPrivateTip(privateTip);
            tipAmsterdam.setStandardTip(standardTip);
            tipAmsterdam.setUsername(username);
            tipAmsterdam.setSendTip(sendTip);
            tipAmsterdam.setGroupName(groupName);
            tipAmsterdam.setGroupTip(groupTip);
            tipAmsterdam.setPicturePath(picturePath.getOriginalFilename());

            tipAmsterdamService.addTipAmsterdam(tipAmsterdam);

            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
