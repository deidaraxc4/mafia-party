package com.deidaraxc4.mafiaparty.constants;

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
