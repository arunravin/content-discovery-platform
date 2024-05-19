package com.krunch.topicsearch.entity;

public class SearchTrendsModel {
	
	private String date;
	private String mytopics;
	private String trendingtopics;
	private String color;
	private String image;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMytopics() {
		return mytopics;
	}
	public void setMytopics(String mytopics) {
		this.mytopics = mytopics;
	}
	public String getTrendingtopics() {
		return trendingtopics;
	}
	public void setTrendingtopics(String trendingtopics) {
		this.trendingtopics = trendingtopics;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "SearchTrendsModel [date=" + date + ", mytopics=" + mytopics + ", trendingtopics=" + trendingtopics
				+ ", color=" + color + ", image=" + image + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((mytopics == null) ? 0 : mytopics.hashCode());
		result = prime * result + ((trendingtopics == null) ? 0 : trendingtopics.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchTrendsModel other = (SearchTrendsModel) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (mytopics == null) {
			if (other.mytopics != null)
				return false;
		} else if (!mytopics.equals(other.mytopics))
			return false;
		if (trendingtopics == null) {
			if (other.trendingtopics != null)
				return false;
		} else if (!trendingtopics.equals(other.trendingtopics))
			return false;
		return true;
	}
	
	
}
