package com.arnhom.bombLine.Network.MessageHandler;

import com.arnhom.bombLine.Game.World;
import com.arnhom.bombLine.Network.ConnectionMailer;
import com.arnhom.bombLine.Network.ConnectionMessageHandler;

public class PlayerHandlerBuilder {

    private World world;
    private ConnectionMailer mailer;

    public PlayerHandlerBuilder(World world, ConnectionMailer mailer){
        this.world = world;
        this.mailer = mailer;
    }

    //@Override
    public ConnectionMessageHandler build() {
        return new PlayerHandler(world,mailer);
    }
}
