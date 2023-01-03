package paket;

import paket2.Weapon_Golok;
import paket2.Weapon_GolokSuper;

public class Story {

    GAMU game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();

    public Story(GAMU g, UI userInterface, VisibilityManager vManager){

        game = g;
        ui = userInterface;
        vm = vManager;    
    }
    public void defaultSetup(){

        player.hp = 10;
        ui.hpNumberLabel.setText("" + player.hp);

        player.curwWeapon = new Weapon_Golok();
        ui.weaponNameLabel.setText(player.curwWeapon.name);
    }
    public void selectPosition(String nextPosition){

        switch(nextPosition){
        case "Pangkalan G*jek" : townGate(); break;
        case "talkGuard": talkGuard(); break;
        case "attackGuard": attackGuard(); break;
        case "Sebrangjalan": crossRoad(); break;
        case "Kidul": Kidul(); break;
        case "Kulon": Kulon(); break;
        case "Kaler": Kaler(); break;   
        }
    }

    public void townGate(){
        ui.mainTextArea.setText("Kamu sedang berada di pangkalan G*jek. \nSeorang driver sedang berdiri didepan mu. \n\napa yang akan kamu lakukan?");
        ui.choice1.setText("Ngobrol sama abang G*jek nya");
        ui.choice2.setText("Serang abang G*jek nya");
        ui.choice3.setText("Biarin aja lah");
        ui.choice4.setText(" ");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "Sebrangjalan";
        game.nextPosition4 = " ";   
    }
    public void talkGuard(){
        ui.mainTextArea.setText("Driver: wei bang. \nkeknya lu bukan orang sini nih. \n\nsorry2 nih ye, kita gabisa kasi jalan buat lu karena lu baru disini");
        ui.choice1.setText(">");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "Pangkalan G*jek";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void attackGuard(){
        ui.mainTextArea.setText("Driver: Weh nantangin ni anak. \nDriver pun memanggil kawan nya lalu memukuli mu beramai-ramai, dan kamu pun menyerah. \n\n(Kamu menerima 3 damage)");
        player.hp = player.hp -3;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText(">");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "Pangkalan G*jek";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void crossRoad(){
        ui.mainTextArea.setText("Kamu berada di sebrang pangkalan ojek. \nkalo kamu milih arah Wetan, kamu balik lagi ke pangkalan.");
        ui.choice1.setText("Pergi ke arah Kidul");
        ui.choice2.setText("Pergi ke arah Kulon");
        ui.choice3.setText("pergi ke arah Kaler ");
        ui.choice4.setText("pergi ke arah Wetan");

        game.nextPosition1 = "Kidul";
        game.nextPosition2 = "Kulon";
        game.nextPosition3 = "Kaler";
        game.nextPosition4 = "Pangkalan G*jek";
    }
    public void Kidul(){
        ui.mainTextArea.setText("Ada warkop nih. \nkamu milih buat ngopi dan sebat dulu. \n\n(Hp kamu nambah deh 2)");
        player.hp = player.hp + 2;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText("Pergi ke arah Wetan");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "Sebrangjalan";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void Kulon(){
        ui.mainTextArea.setText("Kamu jalan melewati rumah warga, lalu menemukan sebuah Golok Super!\n\n(Kamu mendapatkan sebuah Golok Super)");
        
        player.curwWeapon = new Weapon_GolokSuper();
        ui.weaponNameLabel.setText(player.curwWeapon.name);

        ui.choice1.setText("Pergi ke arah kaler");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = "Sebrangjalan";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
    public void Kaler(){
        ui.mainTextArea.setText("");
        ui.choice1.setText(" ");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");
        ui.choice4.setText(" ");

        game.nextPosition1 = " ";
        game.nextPosition2 = " ";
        game.nextPosition3 = " ";
        game.nextPosition4 = " ";
    }
}
