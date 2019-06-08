package hello;

import java.util.Date;

public class Greeting {

    private final int id;
    private final String content;
    private final Date createdTime;
    public Greeting(int id, String content, Date date) {
        this.id = id;
        this.content = content;
        this.createdTime = date;
    }

    public Date getCreatedTime() {
		return createdTime;
	}

	public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}