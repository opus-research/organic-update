package br.pucrio.opus.smells.agglomeration;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

public class Agglomeration {

	@Expose	private Set<SmellyNode> nodes;
	
	public Agglomeration() {
		this.nodes = new HashSet<>();
	}
	
	public Agglomeration(SmellyNode node) {
		this();
		this.addNode(node);
	}
	
	public void addNode(SmellyNode node) {
		this.nodes.add(node);
	}

	public Set<SmellyNode> getNodes() {
		return nodes;
	}
	
	public int size() {
		return nodes.size();
	}
	
	@Override
	public String toString() {
		return nodes.toString();
	}
}
