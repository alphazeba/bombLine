package com.arnhom.bombLine.Network;

import com.arnhom.bombLine.Network.TransferPOJO.Envelope;

public interface ConnectionPushHandler {
    public void pushMessage(Envelope message);
}
