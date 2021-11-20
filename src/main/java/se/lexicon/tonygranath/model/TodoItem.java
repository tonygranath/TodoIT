package se.lexicon.tonygranath.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
	private int id;
	private String title;
	private String taskDescription;
	private LocalDate deadLine;
	private boolean done;
	private Person creator;

	public TodoItem(int id,
					String title,
					String taskDescription,
					LocalDate deadLine,
					boolean done,
					Person creator) {
		this.id = id;
		this.taskDescription = taskDescription;
		this.done = done;
		this.creator = creator;
		setTitle(title);
		setDeadLine(deadLine);
	}

	public TodoItem() {}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title.equals(""))
			throw new RuntimeException("title was empty.");
		else
			this.title = title;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public LocalDate getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(LocalDate deadLine) {
		if (deadLine != null)
			this.deadLine = deadLine;
		else
			throw new RuntimeException("deadLine was null.");
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Person getCreator() {
		return creator;
	}

	public void setCreator(Person creator) {
		this.creator = creator;
	}

	@JsonIgnore
	public boolean isOverDue() {
		return LocalDate.now().isAfter(deadLine);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TodoItem todoItem = (TodoItem) o;
		return id == todoItem.id && done == todoItem.done && title.equals(todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && deadLine.equals(todoItem.deadLine);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, taskDescription, deadLine, done);
	}

	@Override
	public String toString() {
		return "TodoItem{" +
				"id=" + id +
				", title='" + title + '\'' +
				", taskDescription='" + taskDescription + '\'' +
				", deadLine=" + deadLine +
				", done=" + done +
				'}';
	}
}
