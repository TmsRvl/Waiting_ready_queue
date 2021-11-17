import java.util.Arrays;

public class PCB {
    private int processID;
    private int PC; //program counter
    private int priority;
    private int[] registers;
    private String processName;
    private String processState;
    private String[] openFiles;

    public PCB(int processID) {
        this.processID = processID;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setRegisters(int[] registers) {
        this.registers = registers;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public void setOpenFiles(String[] openFiles) {
        this.openFiles = openFiles;
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

    public int[] getRegisters() {
        return registers;
    }

    public String getProcessName() {
        return processName;
    }

    public String getProcessState() {
        return processState;
    }

    public String[] getOpenFiles() {
        return openFiles;
    }

    @Override
    public String toString() {
        return processID + " " + PC + " " + priority + " " + Arrays.toString(registers)
                + " " + processName + " " + processState + " " + Arrays.toString(openFiles);
    }
}