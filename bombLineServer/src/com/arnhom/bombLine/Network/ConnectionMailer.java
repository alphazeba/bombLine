package com.arnhom.bombLine.Network;

import com.arnhom.bombLine.Network.TransferPOJO.Envelope;

public interface ConnectionMailer {
    public void sendEnvelope(Envelope message);
}
