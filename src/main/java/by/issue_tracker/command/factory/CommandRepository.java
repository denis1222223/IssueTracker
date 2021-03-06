package by.issue_tracker.command.factory;

import by.issue_tracker.command.Command;
import by.issue_tracker.command.CommandName;
import by.issue_tracker.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {

    private static final CommandRepository instance = new CommandRepository();

    private Map<CommandName, Command> repository;

    private CommandRepository() {
        repository = new HashMap<CommandName, Command>();

        repository.put(CommandName.SIGN_IN, new SignInCommand());
        repository.put(CommandName.GET_USERS, new GetUsersCommand());
        repository.put(CommandName.UPDATE_USER, new UpdateUserCommand());
        repository.put(CommandName.DELETE_USER, new DeleteUserCommand());
        repository.put(CommandName.CREATE_USER, new CreateUserCommand());
        repository.put(CommandName.GET_PROJECTS, new GetProjectsCommand());
        repository.put(CommandName.CREATE_PROJECT, new CreateProjectCommand());
        repository.put(CommandName.DELETE_PROJECT, new DeleteProjectCommand());
        repository.put(CommandName.UPDATE_PROJECT, new UpdateProjectCommand());
        repository.put(CommandName.GET_SPRINTS, new GetSprintsCommand());
        repository.put(CommandName.CREATE_SPRINT, new CreateSprintCommand());
        repository.put(CommandName.DELETE_SPRINT, new DeleteSprintCommand());
        repository.put(CommandName.UPDATE_SPRINT, new UpdateSprintCommand());
        repository.put(CommandName.GET_TASKS, new GetTasksCommand());
        repository.put(CommandName.CREATE_TASK, new CreateTaskCommand());
        repository.put(CommandName.DELETE_TASK, new DeleteTaskCommand());
        repository.put(CommandName.UPDATE_TASK, new UpdateTaskCommand());
        repository.put(CommandName.GET_COMMENTS, new GetCommentsCommand());
        repository.put(CommandName.CREATE_COMMENT, new CreateCommentCommand());
        repository.put(CommandName.DELETE_COMMENT, new DeleteCommentCommand());
        repository.put(CommandName.UPDATE_COMMENT, new UpdateCommentCommand());
    }

    public static CommandRepository getInstance() {
        return instance;
    }

    public Command getCommand(String requestedCommand) {
        CommandName commandName;
        Command command;

        commandName = CommandName.valueOf(requestedCommand.toUpperCase());
        if (repository.containsKey(commandName)) {
            command = repository.get(commandName);
        } else {
            return null;
        }

        return command;
    }
}
