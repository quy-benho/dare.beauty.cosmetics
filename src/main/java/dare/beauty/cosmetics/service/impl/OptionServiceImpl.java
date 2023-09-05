package dare.beauty.cosmetics.service.impl;

import dare.beauty.cosmetics.data.repository.ColorRepository;
import dare.beauty.cosmetics.model.entities.Color;
import dare.beauty.cosmetics.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    ColorRepository colorRepository;


    @Override
    public List<Color> getAllColor() {
        return colorRepository.findAll();
    }
}
