package dev.syafii.gojakarta.base;

public interface BaseModel {
    interface OnFinishedListener<T> {
        void onSuccess(T data);
        void onFailure(String message);
    }
}
