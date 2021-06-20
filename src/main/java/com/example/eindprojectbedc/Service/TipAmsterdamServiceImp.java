package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.exception.FileStorageException;
import com.example.eindprojectbedc.exception.IdNotFoundException;
import com.example.eindprojectbedc.exception.NotFoundException;
import com.example.eindprojectbedc.model.TipAmsterdam;
import com.example.eindprojectbedc.repository.TipAmsterdamRepository;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TipAmsterdamServiceImp implements TipAmsterdamService {

    private TipAmsterdamRepository tipAmsterdamRepository;
    Path uploads = Paths.get("./uploads");


    @Autowired
    public TipAmsterdamServiceImp(TipAmsterdamRepository tipAmsterdamRepository) {
        this.tipAmsterdamRepository = tipAmsterdamRepository;
    }

    @Override
    public List<TipAmsterdam> getAllTipsAmsterdam() {
        return tipAmsterdamRepository.findAll();
    }

    @Override
    public TipAmsterdam getTipAmsterdam(Long id) {
        return tipAmsterdamRepository.getById(id);
    }

    @Override
    public Optional<TipAmsterdam> getTipAmsterdamById(Long id) {
        if (!tipAmsterdamRepository.existsById(id)) throw new IdNotFoundException(id);
        Optional<TipAmsterdam> tipAmsterdam = tipAmsterdamRepository.findById(id);
        return tipAmsterdam;
    }

//    public Optional<TipAmsterdam> getTwoTipsAmsterdamById(Long idOne, Long idTwo) {
//        if (!tipAmsterdamRepository.existsById(idOne) && !tipAmsterdamRepository.existsById(idTwo)) throw new NotFoundException();
//        Optional<TipAmsterdam> twoTipsAmsterdam = tipAmsterdamRepository.findTipAmsterdamByIdAndId(idOne, idTwo);
//        return twoTipsAmsterdam;
//    }


    @Override
    public void deleteTipAmsterdam(Long id) {
        tipAmsterdamRepository.deleteById(id);
    }

    @Override
    public void addTipAmsterdam(TipAmsterdam tipAmsterdam) {
        tipAmsterdamRepository.save(tipAmsterdam);
    }

    public Resource downloadFile(Long id) {
        Optional<TipAmsterdam> stored = tipAmsterdamRepository.findById(id);

        if (stored.isPresent()) {
            String fileName = stored.get().getPicturePath();
            Path path = this.uploads.resolve(fileName);

            Resource resource = null;

            try {
                resource = new UrlResource(path.toUri());
                return resource;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NotFoundException();
        }
        return null;
    }

    @Override
    public List<Object> getAllPublicTipsAmsterdam() {
        List<TipAmsterdam> tipAmsterdamList = tipAmsterdamRepository.findAll();
        List<Object> publicTipsAmsterdam = new ArrayList<>();
        for (int i = 0; i < tipAmsterdamList.size(); i++) {
            if (tipAmsterdamList.get(i).isPublicTip()) publicTipsAmsterdam.add(tipAmsterdamList.get(i));
        }
        return publicTipsAmsterdam;
    }

    @Override
    public List<Object> getAllPrivateTipsAmsterdam() {
        List<TipAmsterdam> tipAmsterdamList = tipAmsterdamRepository.findAll();
        List<Object> publicTipsAmsterdam = new ArrayList<>();
        for (int i = 0; i < tipAmsterdamList.size(); i++) {
            if (tipAmsterdamList.get(i).isPrivateTip()) publicTipsAmsterdam.add(tipAmsterdamList.get(i));
        }
        return publicTipsAmsterdam;
    }

    @Override
    public List<Object> getAllStandardTipsAmsterdam() {
        List<TipAmsterdam> tipAmsterdamList = tipAmsterdamRepository.findAll();
        List<Object> publicTipsAmsterdam = new ArrayList<>();
        for (int i = 0; i < tipAmsterdamList.size(); i++) {
            if (tipAmsterdamList.get(i).isStandardTip()) publicTipsAmsterdam.add(tipAmsterdamList.get(i));
        }
        return publicTipsAmsterdam;
    }

}

//    @Override
//    public List<TipAmsterdam> getAllPublicTipsAmsterdam() {
//        List<TipAmsterdam> tipsAmsterdam = tipAmsterdamRepository.findAll();
//        List<TipAmsterdam> publicTipsAmsterdam = new ArrayList<>();
//        for (int i = 0; i < tipsAmsterdam.size(); i++) {
//            if (tipsAmsterdam.get(i).isPublicTip()) return publicTipsAmsterdam[i]=tipsAmsterdam;
//        }
//    }

//    @Override
//    public Optional<TipAmsterdam> getPublicTip(Long id) {
//        if (!tipAmsterdamRepository.existsById(id)) throw new IdNotFoundException(id);
//        Optional<TipAmsterdam> tipAmsterdam = tipAmsterdamRepository.findByIsPublicTip();
//        if (tipAmsterdam.get().isPublicTip()) return tipAmsterdam;
//        return null;
//    }

//    @Override
//    public TipAmsterdam saveTipAmsterdam(TipAmsterdam tipAmsterdam){
//        return tipAmsterdamRepository.save(tipAmsterdam);
//    }


//    @Override
//    public void uploadPicturePath(Long id, MultipartFile picturePath) throws IOException {
//        var optionalTipAmsterdam = tipAmsterdamRepository.findById(id);
//        if (optionalTipAmsterdam.isPresent()) {
//            var tipAmsterdam = optionalTipAmsterdam.get();
//            tipAmsterdam.setPicturePath(picturePath.getBytes());
//            tipAmsterdamRepository.save(tipAmsterdam);
//        } else {
//            throw new NotFoundException();
//        }
//    }

//    @Override
//    public byte[] getPicturePath(Long id) {
//        var optionalTipAmsterdam = tipAmsterdamRepository.findById(id);
//        if (optionalTipAmsterdam.isPresent()){
//            return optionalTipAmsterdam.get().getPicturePath();
//        } else {
//            throw new NotFoundException();
//        }
//    }
//}









//
//    public Collection<TipAmsterdam> getTips(){ return
//    tipAmsterdamRepository.findAll(); }
//
//    public TipAmsterdam createTipAmsterdam (@RequestBody TipAmsterdam tipAmsterdam){
//        return tipAmsterdamRepository.save(tipAmsterdam);
//    }
//
//    public Map<String, Boolean> deleteTip(@PathVariable Long id) {
//        TipAmsterdam tipAmsterdam = tipAmsterdamRepository.findById(id).orElseThrow(()-> new RecourceNotFoundException("Tip bestaat niet onder id: " + id));
//
//        tipAmsterdamRepository.delete(tipAmsterdam);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("verwijderd", Boolean.TRUE);
//        return (Map<String, Boolean>) ResponseEntity.ok(response);
//    }
//
