package commands;

import client.DataController;

public class ExitCommand extends AbstractCommand {

    @Override
    public void execute(DataController dataController) {
        System.out.println("������ � �������� ���������. ���������� ������ ���������.");
    }
}
