/**


public interface JArray<T extends JObject> extends
			JObject, Iterable<T> {
	public int length();
	public boolean isMatrix();
	public T at(int index);
	public JArray<? extends T> subArrayAt(int index);
}