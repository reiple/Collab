package collab;

public interface ICommand {

    String executeCommand(IDAO dao) throws Exception;
}
