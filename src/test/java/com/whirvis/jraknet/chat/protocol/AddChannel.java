/*
 *       _   _____            _      _   _          _
 *      | | |  __ \          | |    | \ | |        | |
 *      | | | |__) |   __ _  | | __ |  \| |   ___  | |_
 *  _   | | |  _  /   / _` | | |/ / | . ` |  / _ \ | __|
 * | |__| | | | \ \  | (_| | |   <  | |\  | |  __/ | |_
 *  \____/  |_|  \_\  \__,_| |_|\_\ |_| \_|  \___|  \__|
 *
 * the MIT License (MIT)
 *
 * Copyright (c) 2016-2019 Trent Summerlin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * the above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.whirvis.jraknet.chat.protocol;

import com.whirvis.jraknet.Packet;

/**
 * An <code>ADD_CHANNEL</code> packet.
 * <p>
 * This packet is sent by the {@link com.whirvis.jraknet.chat.server.ChatServer
 * ChatServer} when it has added a text channel.
 * 
 * @author Trent Summerlin
 * @since JRakNet v2.0.0
 */
public final class AddChannel extends ChatPacket {

	/**
	 * The channel the new text channel will have its' messages sent on.
	 */
	public int channel;

	/**
	 * The name of the new text channel.
	 */
	public String channelName;

	/**
	 * Creates a <code>ADD_CHANNEL</code> packet to be encoded.
	 * 
	 * @see #encode()
	 */
	public AddChannel() {
		super(ID_ADD_CHANNEL);
	}

	/**
	 * Creates an <code>ADD_CHANNEL</code> packet to be decoded.
	 * 
	 * @param packet
	 *            the original packet whose data will be read from in the
	 *            {@link #decode()} method.
	 */
	public AddChannel(Packet packet) {
		super(packet);
	}

	@Override
	public void encode() {
		this.writeUnsignedByte(channel);
		this.writeString(channelName);
	}

	@Override
	public void decode() {
		this.channel = this.readUnsignedByte();
		this.channelName = this.readString();
	}

}