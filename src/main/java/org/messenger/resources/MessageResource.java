package org.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.messenger.model.Message;
import org.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	
	MessageService ms= new MessageService();
	
	
	@GET
	public List<Message> getMessages(){
		return ms.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId){
		return ms.getMessage(messageId);
	}
	
	@POST
	public Message addMessage(Message message){
		return ms.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return ms.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id){
		ms.removeMessage(id);
	}
}
