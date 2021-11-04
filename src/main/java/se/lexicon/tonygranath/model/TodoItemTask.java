package se.lexicon.tonygranath.model;

import java.util.Objects;

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
		if (todoItem == null)
			throw new RuntimeException("todoItem was null.");
		else
			this.todoItem = todoItem;
	}

	public Person getAssignee() {
		return assignee;
	}

	public void setAssignee(Person assignee) {
		this.assignee = assignee;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TodoItemTask that = (TodoItemTask) o;
		return id == that.id && assigned == that.assigned && todoItem.equals(that.todoItem);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, assigned, todoItem);
	}

	@Override
	public String toString() {
		return "TodoItemTask{" +
				"id=" + id +
				", assigned=" + assigned +
				", todoItem=" + todoItem +
				'}';
	}
}
