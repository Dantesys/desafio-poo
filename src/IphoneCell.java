import interfaces.Browser;
import interfaces.MusicPlayer;
import interfaces.Phone;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IphoneCell implements MusicPlayer, Phone, Browser {
    ArrayList<String> tabs = new ArrayList<>();
    int tabActive=-1;
    static String music = "";
    private static final Scanner terminal = new Scanner(System.in);

    public IphoneCell() {
        int operation;
        System.out.println("Iphone iniciado");
        do{
            System.out.println("Selecione uma opção: ");
            System.out.println("(1) Player de Musica: ");
            System.out.println("(2) Telefone: ");
            System.out.println("(3) Navegador Web: ");
            System.out.println("(0) Desligar Iphone: ");
            operation = terminal.nextInt();
            switch (operation){
                case (1): musicPlayer();break;
                case (2): phone();break;
                case (3): browser();break;
                default: System.out.println("Desligando...");
            }
        }while(operation>0);
    }
    //Implements MusicPlayer
    private void musicPlayer(){
        int option;
        do{
            System.out.println("Selecione uma opção: ");
            System.out.println("(1) Selecionar Musica: ");
            System.out.println("(2) Tocar Musica: ");
            System.out.println("(3) Pausar Musica: ");
            System.out.println("(0) Voltar ao inicio: ");
            option = terminal.nextInt();
            switch (option){
                case (1): {
                    System.out.println("Selecione uma musica: ");
                    music = terminal.next();
                    selectMusic(music);
                    break;
                }
                case (2): playMusic();break;
                case (3): pauseMusic();break;
                default: System.out.println("Voltando ao inicio");
            }
        }while(option>0);
    }
    @Override
    public void pauseMusic() {
        System.out.println("Pausando "+music);
    }
    @Override
    public void playMusic() {
        System.out.println("Tocando "+music);
    }
    @Override
    public void selectMusic(String musicSelected) {
        System.out.println("Musica Selecionada "+musicSelected);
    }

    //Implements Phone
    private void phone(){
        int option;
        do{
            System.out.println("Selecione uma opção: ");
            System.out.println("(1) Fazer Ligação: ");
            System.out.println("(2) Atender Ligação: ");
            System.out.println("(3) Ver Mensagens de voz: ");
            System.out.println("(0) Voltar ao inicio: ");
            option = terminal.nextInt();
            switch (option){
                case (1): {
                    System.out.println("Digite o numero para quem vai ligar: ");
                    String callNumber = terminal.next();
                    call(callNumber);
                    break;
                }
                case (2): anwser();break;
                case (3): voicemail();break;
                default: System.out.println("Voltando ao inicio");
            }
        }while(option>0);
    }
    @Override
    public void call(String number) {
        System.out.println("Ligando para "+number);
    }
    @Override
    public void anwser() {
        System.out.println("Atendendo Ligação");
    }
    @Override
    public void voicemail() {
        int mails = new Random().nextInt(5);
        System.out.println("Você tem "+mails+" mensagem de voz");
    }

    //Implements Browser
    private void browser(){
        int option;
        do{
            if(tabs == null){
                System.out.println("Você tem 0 paginas abertas!");
            }else{
                System.out.println("Você tem "+tabs.size()+" paginas abertas!");
            }
            if(tabActive>=0)System.out.println("Você está na pagina "+(tabActive+1));
            System.out.println("Selecione uma opção: ");
            System.out.println("(1) Nova Aba: ");
            System.out.println("(2) Mostrar Pagina: ");
            if(tabs != null && !tabs.isEmpty()){
                System.out.println("(3) Fechar pagina: ");
                System.out.println("(4) Atualizar pagina: ");
                if(tabActive>0){
                    System.out.println("(5) Voltar pagina: ");
                }
                if(tabActive<tabs.size()-1){
                    System.out.println("(6) Proxima pagina: ");
                }
            }
            System.out.println("(0) Voltar ao inicio: ");
            option = terminal.nextInt();
            switch (option){
                case (1): newTab();break;
                case (2): {
                    System.out.println("Digite a url: ");
                    String url = terminal.next();
                    showPage(url);
                    break;
                }
                case (3): closeTab();break;
                case (4): updatePage();break;
                case (5): backPage();break;
                case (6): nextPage();break;
                default: System.out.println("Voltando ao inicio");
            }
        }while(option>0);
    }
    @Override
    public void newTab() {
        tabs.add("");
        tabActive = tabs.size()-1;
    }
    @Override
    public void showPage(String url) {
        System.out.println("Acessando...");
        this.tabs.set(tabActive,url);
        System.out.println(url);
    }
    @Override
    public void backPage() {
        if(tabs.size()>1 && tabActive>0){
            tabActive--;
            System.out.println("Voltando...");
        }
    }
    @Override
    public void nextPage() {
        if(tabs.size()>1 && tabActive<tabs.size()-1){
            tabActive--;
            System.out.println("Avançando...");
        }
    }
    @Override
    public void closeTab() {
        System.out.println("Fechando Pagina");
        tabs.remove(tabActive);
        if(tabs.isEmpty()){
            tabActive=-1;
        }
    }
    @Override
    public void updatePage() {
        System.out.println("Pagina Atualizada");
    }
}
