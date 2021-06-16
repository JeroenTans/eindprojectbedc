package com.example.eindprojectbedc.controller;

import com.example.eindprojectbedc.Service.FileStorageService;
import com.example.eindprojectbedc.Service.FileStorageServiceImp;
import com.example.eindprojectbedc.Service.TipAmsterdamService;
import com.example.eindprojectbedc.Service.TipAmsterdamServiceImp;
import com.example.eindprojectbedc.controller.dto.TipAmsterdamDto;
import com.example.eindprojectbedc.controller.dto.TipAmsterdamInputDto;
import com.example.eindprojectbedc.exception.BadRequestException;
import com.example.eindprojectbedc.model.TipAmsterdam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/tips")
public class TipAmsterdamController {

    @Autowired
    TipAmsterdamService tipAmsterdamService;

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping
    public List<TipAmsterdamDto> getAllTipsAmsterdam() {
        var dtos = new ArrayList<TipAmsterdamDto>();
        var allTipsAmsterdam = tipAmsterdamService.getAllTipsAmsterdam();

        for (TipAmsterdam tipAmsterdam : allTipsAmsterdam) {
            dtos.add(TipAmsterdamDto.fromTipAmsterdam(tipAmsterdam));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public TipAmsterdamDto getTipAmsterdam(@PathVariable("id") Long id) {
        var tipAmsterdam = tipAmsterdamService.getTipAmsterdam(id);
        return TipAmsterdamDto.fromTipAmsterdam(tipAmsterdam);
    }

    @PostMapping
    public TipAmsterdamDto saveTipAmsterdam(@RequestBody TipAmsterdamInputDto dto) {
        var tipAmsterdam = tipAmsterdamService.saveTipAmsterdam(dto.toTipAmsterdam());
        return TipAmsterdamDto.fromTipAmsterdam(tipAmsterdam);
    }

    @PostMapping(value = "/tip_upload")
    public ResponseEntity<Object> addTip(@RequestParam String address,
                                         @RequestParam String explanation,
                                         @RequestParam boolean privateTip,
                                         @RequestParam boolean publicTip,
                                         @RequestParam boolean standardTip,
                                         @RequestParam MultipartFile picturePath) {
        try {
            fileStorageService.uploadFile(picturePath);
//
//            TipAmsterdam tipAmsterdam = new TipAmsterdam();
//            tipAmsterdam.setAddress(address);
//            tipAmsterdam.setExplanation(explanation);
//            tipAmsterdam.setPublicTip(publicTip);
//            tipAmsterdam.setPrivateTip(privateTip);
//            tipAmsterdam.setStandardTip(standardTip);
//            tipAmsterdam.setPicturePath(picturePath.getOriginalFilename());

//            tipAmsterdamService.addTipAmsterdam(tipAmsterdam);

            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }
}










//    @Autowired
//    public TipAmsterdamController(TipAmsterdamService tipAmsterdamService, FileStorageServiceImp fileStorageServiceImp) {
//        this.tipAmsterdamService = tipAmsterdamService;
//        this.fileStorageServiceImp = fileStorageServiceImp;
//    }

//    private static final String storageLocation = "/Users/";
//    String fileName = "IMG_1391.HEIC";
//
//    @RequestMapping(value = "/file-upload", method = RequestMethod.POST)
//    @ResponseBody
//    public String uploadFileDown(@RequestParam("picturePath") MultipartFile multipartFile) throws IOException {
//        multipartFile.transferTo(new File(storageLocation + fileName));
//        return "File successfully uploaded!";
//    }

//    @PostMapping("/{id}/picturePath")
//    public void uploadPicturePath(@PathVariable("id") Long id, @RequestParam("picturePath") MultipartFile picturePath)throws IOException {
//        if (picturePath.getContentType()== null || !picturePath.getContentType().equals("application/pdf")) {
//            throw new BadRequestExeption();
//        }
//        tipAmsterdamService.uploadPicturePath(id, picturePath);
//    }

//    @GetMapping("/{id}/picturePath")
//    public ResponseEntity<byte[]> getPicturePath (@PathVariable("id") Long id) {
//        var picturePathBytes = tipAmsterdamService.getPicturePath(id);
//
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"image.pdf\"").body(picturePathBytes);
//    }








//      @Autowired
//    private TipAmsterdamServiceImp tipAmsterdamServiceImp;
//    private TipAmsterdamRepository tipAmsterdamRepository;
//
//    @GetMapping("get_tips")
//    public ResponseEntity<Object> getAllTipsAmsterdam(){
//        List<TipAmsterdam> allTipsAmsterdam = this.tipAmsterdamRepository.findAll();
//        return new ResponseEntity<>(allTipsAmsterdam, HttpStatus.OK);
//    }



//    @GetMapping("/get_tips")
//    public ResponseEntity<Object> getTipsAmsterdam(){ return ResponseEntity.ok().body(tipAmsterdamServiceImp.getTips()); }
//
//    @PostMapping("/post_tips")
//    public ResponseEntity<TipAmsterdam> createTipAmsterdam (@RequestBody TipAmsterdam tipAmsterdam){
//
//        return ResponseEntity.ok().body(tipAmsterdamServiceImp.createTipAmsterdam(tipAmsterdam));
//    }
//
//    @DeleteMapping("/delete_tips/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteTip(@PathVariable Long id){
//        return ResponseEntity.ok(tipAmsterdamServiceImp.deleteTip(id));
//    }
//
////    @PostMapping("/image/{id}")
////    public void uploadImage(@PathVariable("id") Long id, @RequestParam("picturePath") MultipartFile picturePath) throws Exception {
////        if (picturePath.getContentType() == null || !picturePath.getContentType().equals("application/pdf")) {
////            throw new BadRequestExeption();
////        }
////        tipAmsterdamServiceImp.uploadImage(id, picturePath);
////    }
//
////    @PostMapping("/uploadImage")
////    public String uploadImage( @RequestParam("picturePath") MultipartFile picturePath) throws Exception {
////        String returnValue = "";
////        tipAmsterdamServiceImp.saveImage(picturePath);
////
////        return returnValue;
////    }
////    public ResponseEntity<Tip> updateTip(@PathVariable Long id, @RequestBody Tip tipDetails) {
////        Tip tip = tipRepository.findById(id)
////                .orElseThrow(()-> new RecourceNotFoundException(("Tip bestaat niet onder id: " + id)));
////
////        tip.setAddress(tipDetails.getAddress());
////        tip.setExplanation(tipDetails.getExplanation());
////        tip.setPrivateTip(tipDetails.get);
////    }
//
