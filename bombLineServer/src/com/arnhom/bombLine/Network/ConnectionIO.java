package com.arnhom.bombLine.Network;

import com.arnhom.bombLine.Network.TransferPOJO.Envelope;

public interface ConnectionIO extends ConnectionMailer {
    public void sendEnvelope(Envelope message);
    public Envelope getMail();
}
