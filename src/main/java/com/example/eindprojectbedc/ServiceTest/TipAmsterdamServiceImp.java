package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.exception.IdNotFoundException;
import com.example.eindprojectbedc.exception.NotFoundException;
import com.example.eindprojectbedc.model.Authority;
import com.example.eindprojectbedc.model.TipAmsterdam;
import com.example.eindprojectbedc.repository.AuthorityRepository;
import com.example.eindprojectbedc.repository.TipAmsterdamRepository;
import com.example.eindprojectbedc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipAmsterdamServiceImp implements TipAmsterdamService {

    AuthorityRepository authorityRepository;
    UserRepository userRepository;
    private ReviewService reviewService;
    private TipAmsterdamRepository tipAmsterdamRepository;
    Path uploads = Paths.get("./uploads");

    @Autowired
    public TipAmsterdamServiceImp(TipAmsterdamRepository tipAmsterdamRepository) {
        this.tipAmsterdamRepository = tipAmsterdamRepository;
    }

//    public List<Review> getReviewsOfTips (Long id) {
//        Optional<TipAmsterdam> tipAmsterdam = tipAmsterdamRepository.findById(id);
//
//    }

    @Override
    public List<TipAmsterdam> getAllTipsAmsterdam() {
        return tipAmsterdamRepository.findAll();
    }

    @Override
    public TipAmsterdam getTipAmsterdam(Long id) {
//        return tipAmsterdamRepository.getById(id);
        var optionalTipAmsterdam = tipAmsterdamRepository.findById(id);
        if (optionalTipAmsterdam.isPresent()) {
            return optionalTipAmsterdam.get();
        } else throw new NotFoundException();
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
    public TipAmsterdam addTipAmsterdam(TipAmsterdam tipAmsterdam) {
        return tipAmsterdamRepository.save(tipAmsterdam);
    }

    @Override
    public void addTipAmsterdamAdmin(TipAmsterdam tipAmsterdam) {
        String username = tipAmsterdam.getUsername();
        Authority userAuthority = new Authority();
        String authority = String.valueOf(authorityRepository.getAuthorityByUsername(username));
        if (authority.equals("ADMIN")) {
            tipAmsterdamRepository.save(tipAmsterdam);
        }
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

    @Override
    public List<Object> getAllPrivateTipsAmsterdamByUsername(String username) {
        List<TipAmsterdam> tipAmsterdamList = tipAmsterdamRepository.findAll();
        List<Object> privateTipsAmsterdam = new ArrayList<>();
        for (int i = 0; i < tipAmsterdamList.size(); i++) {
            if (tipAmsterdamList.get(i).getUsername().equals(username) && tipAmsterdamList.get(i).isPrivateTip()) privateTipsAmsterdam.add(tipAmsterdamList.get(i));
        }
        return privateTipsAmsterdam;
    }

    @Override
    public List<Object> getAllPublicTipsAmsterdamByUsername(String username) {
        List<TipAmsterdam> tipAmsterdamList = tipAmsterdamRepository.findAll();
        List<Object> publicTipsAmsterdam = new ArrayList<>();
        for (int i = 0; i < tipAmsterdamList.size(); i++) {
            if (tipAmsterdamList.get(i).getUsername().equals(username) && tipAmsterdamList.get(i).isPublicTip()) publicTipsAmsterdam.add(tipAmsterdamList.get(i));
        }
        return publicTipsAmsterdam;
    }


}
