package com.hd.hamsterD.model;

import java.util.Arrays;
import java.util.Objects;


public class StudyGroup {

	private String academy;
	private String groupName;
	private int memberCount;
    private int weight;
    private int penalty;
	public StudyGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudyGroup(String academy, String groupName, int memberCount, int weight, int penalty) {
		super();
		this.academy = academy;
		this.groupName = groupName;
		this.memberCount = memberCount;
		this.weight = weight;
		this.penalty = penalty;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	@Override
	public String toString() {
		return "StudyGroup [academy=" + academy + ", groupName=" + groupName + ", memberCount=" + memberCount
				+ ", weight=" + weight + ", penalty=" + penalty + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(academy, groupName, memberCount, penalty, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudyGroup other = (StudyGroup) obj;
		return Objects.equals(academy, other.academy) && Objects.equals(groupName, other.groupName)
				&& memberCount == other.memberCount && penalty == other.penalty && weight == other.weight;
	}
	
	
    
}
