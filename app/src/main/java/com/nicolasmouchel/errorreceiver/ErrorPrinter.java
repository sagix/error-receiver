package com.nicolasmouchel.errorreceiver;
import android.content.Context;

interface ErrorPrinter<C extends Context> {
    void print(C context, int code, String message);
}
