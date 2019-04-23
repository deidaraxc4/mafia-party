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
        Narrator("Narrator"), Vigilante("Vigilante"),Sheriff("Sheriff"),Lookout("Lookout"),Veteran("Veteran"),Doctor("Doctor"),
        BodyGuard("Bodyguard"),Mayor("Mayor"),Escort("Escort"),Retributionist("Retributionist"),Transporter("Transporte"),Godfather("Godfather"),
        Mafioso("Mafioso"),Framer("Framer"),Blackmailer("Blackmailer"),Consort("Consort"),Survivor("Survivor"),Jester("Jester"),Executioner("Executioner"),Serial_Killer("Serial Killer");

        private String role;

        PlayerRole(String role) {
            this.role = role;
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
