package com.noroff.mefit.services.profile;

import com.noroff.mefit.models.Profile;
import com.noroff.mefit.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProfileServiceImpl implements ProfileService{
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findById(Integer integer) {
        return profileRepository.findById(integer).get();
    }

    @Override
    public Collection<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile add(Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    public Profile update(Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        profileRepository.deleteById(id);
    }
}
