package com.arnhom.bombLine.Network;

import com.arnhom.bombLine.Network.TransferPOJO.Envelope;

public interface ConnectionMessageHandler {
    public void handleMessage(Envelope message);
}
