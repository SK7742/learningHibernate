package beans;

import java.util.Set;

public class Actor {
	private int actorId;
	private String actorName;
	private Set<Movies> movies;
	public int getActorId() {
		return actorId; 
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public Set<Movies> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
	
	

	
}
