package hr.fer.tel.hmo.vnf;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a service chain of components
 */
public class ServiceChain implements Iterable<Component> {

	private List<Component> components;

	private double latency;

	/**
	 * Create a new service chain with desired maximal latency
	 *
	 * @param latency maximal latency
	 */
	public ServiceChain(double latency) {
		this.components = new LinkedList<>();
		this.latency = latency;
	}

	public void addComponent(Component component) {
		components.add(component);
	}

	public List<Component> getComponents() {
		return components;
	}

	public double getLatency() {
		return latency;
	}

	@Override
	public Iterator<Component> iterator() {
		return components.iterator();
	}
}
