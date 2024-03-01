package Model.Vehicles;

public interface HasStorage<T> {
    public void openStorage();
    public void closeStorage();
    public boolean isStorageOpen();
    public void addToStorage(T toStore);
    public T removeThing();
    public int countThings();
}
