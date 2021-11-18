public class Emulation {

    private static PCB[] fill(){
        String programs[] = {"Chrome", "Word", "Paint", "Spotify", "Photoshop", "Notepad",
                "VirtualBox", "PowerPoint", "Excel", "Settings", "PowerShell", "Premiere",
                "Photo", "Calendar", "Calculator"};
        PCB out[] = new PCB[(int) (Math.random() * (20 - 5)) + 5];
        for(int i = 0; i < out.length; i++){
            out[i] = new PCB(i);
            out[i].setPC((int) (Math.random() * (500 - 1)) + 1);
            out[i].setPriority((int) (Math.random() * 3));
            out[i].setProcessName(programs[i]);
            out[i].setProcessState("new");
        }
        return out;
    }

    public static void main(String[] args) {
        Queue<PCB> r = new Queue<>("Ready-Queue");
        Queue<PCB> w = new Queue<>("Waiting-Queue");
        PCB processes[] = fill();
        
    }
}
