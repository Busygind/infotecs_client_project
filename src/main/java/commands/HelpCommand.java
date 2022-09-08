package commands;

import client.DataController;

public class HelpCommand extends AbstractCommand {

    @Override
    public void execute(DataController dataController) {
        System.out.println("������ ��������� ������: \n"
                + "* list -- ������� ������ ���������, ��������������� �� ����� \n"
                + "* info <id> -- ������� ���������� � �������� �� ��� id \n"
                + "* add <name> -- �������� �������� � ��������� ������ \n"
                + "* delete <id> -- ������� �������� �� ��� id \n"
                + "* exit -- ��������� ������ � ��������");
    }
}
