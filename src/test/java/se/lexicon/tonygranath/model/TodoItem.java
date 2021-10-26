package se.lexicon.tonygranath.model;

import java.time.LocalDate;

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

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title.equals(""))
			throw new RuntimeException("title was empty");
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
			throw new RuntimeException("deadLine was null");
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

	public boolean isOverDue() {
		return LocalDate.now().isAfter(deadLine);
	}

	public String getSummary() {
		return "{ id: " + id
				+ ",\ntitle: " + title
				+ ",\ntaskDescription: " + taskDescription
				+ ",\ndeadLine: " + deadLine
				+ ",\ndone: " + done
				+ ",\ncreator: " + creator.getSummary() + " }";
	}

}
