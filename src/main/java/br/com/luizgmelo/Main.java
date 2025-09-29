package br.com.luizgmelo;

import br.com.luizgmelo.service.ServiceApi;

public class Main {
    public static void main(String[] args) {
        ServiceApi serviceApi = new ServiceApi();
        serviceApi.getPlayingMovies();
    }
}
