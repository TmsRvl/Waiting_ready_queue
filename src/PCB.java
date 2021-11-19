import java.util.Arrays;

public class PCB {
    private int processID;
    private int PC; // Program counter
    private int priority;
    private String processName;
    private String processState;
    private PCB next;

    public PCB(int processID) {
        this.processID = processID;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public PCB getNext() {
        return next;
    }

    public void setNext(PCB next) {
        this.next = next;
    }

    public int getProcessID() {
        return processID;
    }

    public int getPC() {
        return PC;
    }

    public int getPriority() {
        return priority;
    }

    public String getProcessName() {
        return processName;
    }

    public String getProcessState() {
        return processState;
    }

    @Override
    public String toString() {
        return "[ " + "id -> "+processID + ", name -> "+processName + ", pc -> "+PC
                + ", priority -> "+priority + ", state -> "+processState + " ]";
    }

}