package commands;

import client.DataController;

public class HelpCommand extends AbstractCommand {

    @Override
    public void execute(DataController dataController) {
        System.out.println("Список доступных команд: \n"
                + "* list -- вывести список студентов, отсортированный по имени \n"
                + "* info <id> -- вывести информацию о студенте по его id \n"
                + "* add <name> -- добавить студента с указанным именем \n"
                + "* delete <id> -- удалить студента по его id \n"
                + "* exit -- завершить работу с клиентом");
    }
}
