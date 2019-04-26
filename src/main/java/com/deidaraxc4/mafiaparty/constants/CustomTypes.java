package com.deidaraxc4.mafiaparty.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomTypes {

    public enum GameState {
        EVENING("Evening"),
        MORNING("Morning"),
        LOBBY("Lobby"),
        END("End");

        private String state;

        GameState(String state) {
            this.state = state;
        }

        public String toString() {
            return state;
        }
    }

    public enum PlayerRole {
        Narrator("Narrator","Town"), Vigilante("Vigilante","Town"),Sheriff("Sheriff","Town"),Lookout("Lookout","Town"),Veteran("Veteran","Town"),Doctor("Doctor","Town"),
        BodyGuard("Bodyguard","Town"),Mayor("Mayor","Town"),Escort("Escort","Town"),Retributionist("Retributionist","Town"),Transporter("Transporter","Town"),Godfather("Godfather","Mafia"),
        Mafioso("Mafioso","Mafia"),Framer("Framer","Mafia"),Blackmailer("Blackmailer","Mafia"),Consort("Consort","Mafia"),Survivor("Survivor","Neutral"),Jester("Jester","Neutral"),Executioner("Executioner","Neutral"),Serial_Killer("Serial Killer","Neutral");

        private String role;
        private String alignment;

        PlayerRole(String role, String alignment) {
            this.alignment = alignment;
            this.role = role;
        }

        public static PlayerRole getRandomRole() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }

        public static PlayerRole getRandomTownRole() {
            Random random = new Random();
            while(true) {
                PlayerRole role = values()[random.nextInt(values().length)];
                if(role.getAlignment().equals("Town")) {
                    return role;
                }
            }
        }

        // 2 neutral, 9 town, 4 mafia
        // 0-10 is town, 11-15 mafia, 16-19 is neutral
        public static List<PlayerRole> getRandomRoles() {
            List<PlayerRole> list = new ArrayList<>();
            Random random = new Random();
            for(int i = 0; i < 9; i++) {
                list.add(values()[random.nextInt(11)]);
            }
            for(int i = 0; i < 4; i++) {
                list.add(values()[random.nextInt(16) + 11]);
            }
            for(int i = 0; i < 2; i++) {
                list.add(values()[random.nextInt(20) + 16]);
            }
            return list;
        }

        public String getAlignment() {
            return alignment;
        }

        public String toString() {
            return role;
        }
    }

    public enum PlayerState {
        DEAD("Dead"), ALIVE("Alive");
        private String state;

        PlayerState(String state) {
            this.state = state;
        }

        public String toString() {
            return state;
        }
    }

    void foo() {
        System.out.print(PlayerState.DEAD.name());
    }
}
