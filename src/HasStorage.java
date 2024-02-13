
public interface HasStorage<T> {
    public void openStorage();
    public void closeStorage();
    public boolean isStorageOpen();
    public void storeThing(T toStore);
    public T removeThing();
    public int countThings();
}
