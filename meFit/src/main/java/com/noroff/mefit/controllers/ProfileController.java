package com.noroff.mefit.controllers;

import com.noroff.mefit.models.Profile;
import com.noroff.mefit.services.profile.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {

        this.profileService = profileService;
    }

    @GetMapping({"id"})
    public ResponseEntity findById(@PathVariable int id){

        return ResponseEntity.ok(profileService.findById(id));
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody Profile entity) throws URISyntaxException {
        //Add profile
        profileService.add(entity);
        URI uri = new URI("profile/" + entity.getId());
        return ResponseEntity.created(uri).build();
    }


}
