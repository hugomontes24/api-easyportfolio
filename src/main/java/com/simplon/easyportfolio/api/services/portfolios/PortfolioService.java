package com.simplon.easyportfolio.api.services.portfolios;

import com.simplon.easyportfolio.api.repositories.portfolios.PortfolioRepository;
import com.simplon.easyportfolio.api.repositories.portfolios.PortfolioRepositoryModel;
import com.simplon.easyportfolio.api.services.users.UserServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    PortfolioRepository portfolioRepository;
    public boolean add(PortfolioServiceModel portfolioServiceModel) {
        PortfolioRepositoryModel portfolioRepositoryModel =
                new PortfolioRepositoryModel(portfolioServiceModel.getTitle(),
                        portfolioServiceModel.getName(), portfolioServiceModel.getFirstname(),
                        portfolioServiceModel.getEmail());
        PortfolioRepositoryModel portfolioRepositoryReturn = portfolioRepository.save(portfolioRepositoryModel);

         return portfolioRepositoryReturn != null;
    }

    public PortfolioServiceModel findById(Long id) {
        Optional<PortfolioRepositoryModel> portfolioRepositoryModel = portfolioRepository.findById(id);

        if (portfolioRepositoryModel.isEmpty()){
            return null;
        }else{
            return new PortfolioServiceModel(Optional.ofNullable(portfolioRepositoryModel.get().getId()),
                    portfolioRepositoryModel.get().getTitle(), portfolioRepositoryModel.get().getName(),
                    portfolioRepositoryModel.get().getFirstname(), portfolioRepositoryModel.get().getEmail());
        }

    }
}
