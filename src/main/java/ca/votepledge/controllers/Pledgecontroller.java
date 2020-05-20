package ca.votepledge.controllers;

import ca.votepledge.model.Pledge;
import ca.votepledge.repositories.VotersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Pledgecontroller {

    @Autowired
    private VotersRepository repository;
    private AtomicLong nextId = new AtomicLong();
    @GetMapping("/hello")
    public String Hello(String name,Model model){
        repository.deleteAll();
        return "Hello Spring";

    }

    @GetMapping("/pledges/{id}")
    public Optional<Pledge> getPledge(@PathVariable("id") String pledgeId) throws IllegalArgumentException{
        System.out.println(pledgeId);
        Optional<Pledge> pledge = repository.findById(pledgeId);
        if(pledge.isPresent()){
            return  pledge;
        }
        throw new IllegalArgumentException();
    }

    @PostMapping("/pledges")
    public Pledge createNewPledge(@RequestBody Pledge pledge){
        List pledges = repository.findAll();

        pledge.setId(pledges.size()+1);
//        pledges.add(pledge);
        repository.save(pledge);
        return pledge;
    }

    @GetMapping("/pledges")
    public List<Pledge> getAll(){
        List pledges = repository.findAll();
        return pledges;
    }

    @GetMapping("/length")
    public int length(){
        List pledges = repository.findAll();
        return pledges.size();
    }



}
