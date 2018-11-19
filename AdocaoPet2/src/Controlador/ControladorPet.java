package Controlador;

import TelaPet.DoarPet;
import Entidade.Animal;
import Entidade.ConteudoTelaPet;
import Entidade.Cachorro;
import Entidade.Gato;
import Entidade.Passaro;
import Exception.MaximoDaMesmaEspecieException;
import Exception.MaximoDeAnimaisAdotadosException;
import Mapeadores.MapeadorCachorro;
import Mapeadores.MapeadorGato;
import Mapeadores.MapeadorPassaro;
import TelaPet.AdotaPet;
import TelaPet.ListaParaAdocao;
import java.rmi.server.UID;
import java.util.ArrayList;

public final class ControladorPet {

    private static ControladorPet instancia;
    private AdotaPet adotaPet;
    private DoarPet doarPet;
    private ListaParaAdocao listaParaAdocao;
    private MapeadorCachorro mapeadorCachorro;
    private MapeadorGato mapeadorGato;
    private MapeadorPassaro mapeadorPassaro;
    private final int CACHORRO = 1, GATO = 2, PASSARO = 3;

    private ControladorPet() {
        this.adotaPet = new AdotaPet();
        this.listaParaAdocao = new ListaParaAdocao();
        this.doarPet = new DoarPet();
        this.mapeadorCachorro = new MapeadorCachorro();
        this.mapeadorGato = new MapeadorGato();
        this.mapeadorPassaro = new MapeadorPassaro();
    }

    public static synchronized ControladorPet getInstance() {
        if (instancia == null) {
            instancia = new ControladorPet();
        }
        return instancia;
    }

    public void doarPet() {
        doarPet.fecha();
        doarPet = new DoarPet();
        doarPet.exibe();
    }

    public void adotaPet() {
        adotaPet.fecha();
        adotaPet = new AdotaPet();
        adotaPet.exibe();
    }

    public void exibeAdocao(int pet, int opcaoRaca, int opcaoSexo) {
        ArrayList<ConteudoTelaPet> listagemPets = new ArrayList<ConteudoTelaPet>();
        switch (pet) {
            case CACHORRO:
                for (Cachorro cachorro : mapeadorCachorro.getList()) {
                    if (opcaoRaca == cachorro.getRaca() && opcaoSexo == cachorro.getSexo()) {
                        listagemPets.add(empacotaCachorro(cachorro));
                    }
                }
                listaParaAdocao.fecha();
                listaParaAdocao = new ListaParaAdocao();
                listaParaAdocao.listagem(CACHORRO, listagemPets);
                break;
            case GATO:
                for (Gato gato : mapeadorGato.getList()) {
                    if (opcaoRaca == gato.getRaca() && opcaoSexo == gato.getSexo()) {
                        listagemPets.add(empacotaGato(gato));
                    }
                }
                listaParaAdocao.fecha();
                listaParaAdocao = new ListaParaAdocao();
                listaParaAdocao.listagem(GATO, listagemPets);
                break;
            case PASSARO:
                for (Passaro passaro : mapeadorPassaro.getList()) {
                    if (opcaoRaca == passaro.getRaca() && opcaoSexo == passaro.getSexo()) {
                        listagemPets.add(empacotaPassaro(passaro));
                    }
                }
                listaParaAdocao.fecha();
                listaParaAdocao = new ListaParaAdocao();
                listaParaAdocao.listagem(PASSARO, listagemPets);
                break;

        }
    }

    public void cadastroDog(ConteudoTelaPet conteudoTela) {
        conteudoTela.identificador = geradorCodigo(CACHORRO);
        System.out.println("O indentificador do cachorro é: " + conteudoTela.identificador);
        Cachorro cachorro = desempacotaCachorro(conteudoTela);
        mapeadorCachorro.put(cachorro);
        ControladorPrincipal.getInstancia().doaCachorro(cachorro);
        menuPrincipal();
    }

    public void cadastroGato(ConteudoTelaPet conteudoTela) {
        conteudoTela.identificador = geradorCodigo(GATO);
        System.out.println("O indentificador do gato é: " + conteudoTela.identificador);
        Gato gato = desempacotaGato(conteudoTela);
        mapeadorGato.put(gato);
        ControladorPrincipal.getInstancia().doaGato(gato);
        menuPrincipal();
    }

    public void cadastroPassaro(ConteudoTelaPet conteudoTela) {
        conteudoTela.identificador = geradorCodigo(PASSARO);
        System.out.println("O indentificador do passaro é: " + conteudoTela.identificador);
        Passaro passaro = desempacotaPassaro(conteudoTela);
        mapeadorPassaro.put(passaro);
        ControladorPrincipal.getInstancia().doaPassaro(passaro);
        menuPrincipal();
    }

    private Cachorro desempacotaCachorro(ConteudoTelaPet conteudoTela) {
        return new Cachorro(conteudoTela.nomePet, conteudoTela.idadePet, conteudoTela.racaPet, conteudoTela.sexoPet, conteudoTela.identificador);
    }

    private Gato desempacotaGato(ConteudoTelaPet conteudoTela) {
        return new Gato(conteudoTela.nomePet, conteudoTela.idadePet, conteudoTela.racaPet, conteudoTela.sexoPet, conteudoTela.identificador);
    }

    private Passaro desempacotaPassaro(ConteudoTelaPet conteudoTela) {
        return new Passaro(conteudoTela.nomePet, conteudoTela.idadePet, conteudoTela.racaPet, conteudoTela.sexoPet, conteudoTela.identificador);
    }

    private ConteudoTelaPet empacotaCachorro(Cachorro cachorro) {
        return new ConteudoTelaPet(cachorro.getNome(), cachorro.getIdade(), cachorro.getRaca(), cachorro.getSexo(), cachorro.getIdentificadorCachorro());
    }

    private ConteudoTelaPet empacotaGato(Gato gato) {
        return new ConteudoTelaPet(gato.getNome(), gato.getIdade(), gato.getRaca(), gato.getSexo(), gato.getIdentificadorGato());
    }

    private ConteudoTelaPet empacotaPassaro(Passaro passaro) {
        return new ConteudoTelaPet(passaro.getNome(), passaro.getIdade(), passaro.getRaca(), passaro.getSexo(), passaro.getIdentificadorPassaro());
    }

    public void menuPrincipal() {
        ControladorPrincipal.getInstancia().menu();
    }

    public ArrayList<Animal> adocoesUsuario() {
        ArrayList<Animal> adocoes = ControladorPrincipal.getInstancia().adocoesUsuario();
        return adocoes;
    }

    public void petAdotado(String id, int pet) throws MaximoDeAnimaisAdotadosException, MaximoDaMesmaEspecieException {
        ArrayList<Animal> animal = adocoesUsuario();
        if (adocoesUsuario().size() > 4) {
            throw new MaximoDeAnimaisAdotadosException();
        } else {
            switch (pet) {
                case CACHORRO:
                    Cachorro cachorro = mapeadorCachorro.getCachorro(id);
                    for (Animal adocao : animal) {
                        if (adocao.getEspecie() == cachorro.getEspecie()) {
                            throw new MaximoDaMesmaEspecieException();
                        }
                    }
                    ControladorPrincipal.getInstancia().adocaoCachorro(cachorro);
                    mapeadorCachorro.remove(cachorro);
                    listaParaAdocao.exibeSucessoAdocao(cachorro.getNome());
                    System.out.print(cachorro.getIdentificadorCachorro());
                    return;
                case GATO:
                    Gato gato = mapeadorGato.getGato(id);
                    for (Animal adocao : animal) {
                        if (adocao.getEspecie() == gato.getEspecie()) {
                            throw new MaximoDaMesmaEspecieException();
                        }
                    }
                    ControladorPrincipal.getInstancia().adocaoGato(gato);
                    mapeadorGato.remove(gato);
                    listaParaAdocao.exibeSucessoAdocao(gato.getNome());
                    System.out.print(gato.getIdentificadorGato());
                    return;
                case PASSARO:
                    Passaro passaro = mapeadorPassaro.getPassaro(id);
                    for (Animal adocao : animal) {
                        if (adocao.getEspecie() == passaro.getEspecie()) {
                            throw new MaximoDaMesmaEspecieException();
                        }
                    }
                    ControladorPrincipal.getInstancia().adocaoPassaro(passaro);
                    mapeadorPassaro.remove(passaro);
                    listaParaAdocao.exibeSucessoAdocao(passaro.getNome());
                    System.out.print(passaro.getIdentificadorPassaro());
                    return;
            }
        }
    }

    private String geradorCodigo(int pet) {
        int i = 0;
        String id = "";
        switch (pet) {
            case CACHORRO:
                if (mapeadorCachorro.getList().isEmpty()) {
                    return "Cachorro: " + i;
                } else {
                    for (int j = 0; j <= mapeadorCachorro.getList().size(); j++) {
                        id = "Cachorro: " + i;
                        for (Cachorro cachorro : mapeadorCachorro.getList()) {
                            if (id.equals(cachorro.getIdentificadorCachorro())) {
                                i++;
                            }
                        }
                    }
                    return id;
                }
            case GATO:
                if (mapeadorGato.getList().isEmpty()) {
                    return "Gato: " + i;
                } else {
                    for (int j = 0; j <= mapeadorGato.getList().size(); j++) {
                        id = "Gato: " + i;
                        for (Gato gato : mapeadorGato.getList()) {
                            if (id.equals(gato.getIdentificadorGato())) {
                                i++;
                            }
                        }
                    }
                    return id;
                }
            case PASSARO:
                if (mapeadorPassaro.getList().isEmpty()) {
                    return "Passaro: " + i;
                } else {
                    for (int j = 0; j <= mapeadorPassaro.getList().size(); j++) {
                        id = "Passaro: " + i;
                        for (Passaro passaro : mapeadorPassaro.getList()) {
                            if (id.equals(passaro.getIdentificadorPassaro())) {
                                i++;
                            }
                        }
                    }
                    return id;
                }    
        }
        return null;
    }
}
