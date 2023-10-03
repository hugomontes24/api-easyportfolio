package com.simplon.easyportfolio.api.controllers.portfolios;


import com.simplon.easyportfolio.api.exceptions.PortfolioNotFoundException;
import com.simplon.easyportfolio.api.services.portfolios.PortfolioService;
import com.simplon.easyportfolio.api.services.portfolios.PortfolioServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("portfolios")
@CrossOrigin
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @PostMapping
    public boolean add(@RequestBody PortfolioDTO portfolioDTO){
        PortfolioServiceModel portfolioServiceModel = new PortfolioServiceModel( portfolioDTO.getTitle(),
                portfolioDTO.getName(), portfolioDTO.getFirstname(), portfolioDTO.getEmail());

        return portfolioService.add(portfolioServiceModel);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<PortfolioGetDTO> findById(@PathVariable Long id){
        try{
            PortfolioServiceModel portfolioServiceModel=portfolioService.findById(id);
            PortfolioGetDTO portfolioGetDTO= new PortfolioGetDTO(portfolioServiceModel.getId().get(),
                    portfolioServiceModel.getTitle(), portfolioServiceModel.getName(),
                    portfolioServiceModel.getFirstname(), portfolioServiceModel.getEmail());
            return new ResponseEntity<>(portfolioGetDTO, HttpStatus.OK);

        }catch (PortfolioNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getReason());
        }
    }

}
