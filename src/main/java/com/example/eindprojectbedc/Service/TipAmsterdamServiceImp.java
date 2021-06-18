package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.exception.FileStorageException;
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
import java.util.List;
import java.util.Optional;

@Service
public class TipAmsterdamServiceImp implements TipAmsterdamService{

    private TipAmsterdamRepository tipAmsterdamRepository;
    Path uploads = Paths.get("./uploads");


    @Autowired
    public TipAmsterdamServiceImp(TipAmsterdamRepository tipAmsterdamRepository){
        this.tipAmsterdamRepository = tipAmsterdamRepository;
    }

    @Override
    public List<TipAmsterdam> getAllTipsAmsterdam() {
        return tipAmsterdamRepository.findAll();
    }

    @Override
    public TipAmsterdam getTipAmsterdam(Long id) {
        var optionalTipAmsterdam = tipAmsterdamRepository.findById(id);
        if (optionalTipAmsterdam.isPresent()){
            return optionalTipAmsterdam.get();
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public TipAmsterdam saveTipAmsterdam(TipAmsterdam tipAmsterdam){
        return tipAmsterdamRepository.save(tipAmsterdam);
    }

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

}

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
