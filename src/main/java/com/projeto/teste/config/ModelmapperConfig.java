package com.projeto.teste.config;

import org.modelmapper.ModelMapper;

public class ModelmapperConfig {

    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper;
    }
}
