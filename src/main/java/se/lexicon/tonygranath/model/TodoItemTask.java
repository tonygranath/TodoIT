package se.lexicon.tonygranath.model;

public class TodoItemTask {
	private int id;
	private boolean assigned;
	private TodoItem todoItem;
	private Person assignee;

	public TodoItemTask(int id, TodoItem todoItem) {
		this.id = id;

		if (todoItem != null)
			this.todoItem = todoItem;
		else
			throw new RuntimeException("todoItem was null.");
	}

	public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
		this(id, todoItem);

		this.assignee = assignee;

		if (assignee != null)
			assigned = true;
	}

	public int getId() {
		return id;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	public TodoItem getTodoItem() {
		return todoItem;
	}

	public void setTodoItem(TodoItem todoItem) {
		this.todoItem = todoItem;
	}

	public Person getAssignee() {
		return assignee;
	}

	public void setAssignee(Person assignee) {
		this.assignee = assignee;
	}

	public String getSummary() {
		return "{ id: " + id
				+ ",\nassigned: " + assigned
				+ ",\ntodoItem: " + todoItem.getSummary()
				+ ",\nassignee: " + assignee.getSummary() + " }";
	}
}
