package com.agit.crm.infrastructure.report;

/**
 * Generic exception to be used by backend and frontend
 * @author bayutridewanto
 *
 */
public class GenericException extends Exception{
	private static final long serialVersionUID = 1L;

	private MessageCode messageCode;
	private Object[] messageParams = new Object[0];
	
	/**
	 * Get message code object
	 * @return message code object
	 */
	public MessageCode getMessageCode(){
		return this.messageCode;
	}
	
	/**
	 * Get message code key
	 * @return
	 */
	public String getMessageKey(){
		return this.messageCode.getKey();
	}
	
	/**
	 * For unexpected errors
	 * @param t throwable
	 */
	public GenericException(Throwable t){
		this(MessageCode.E_GENERIC_ERROR, t);
	}
	
	/**
	 * Create
	 * @param t throwable
	 * @param msgParams create with message parameters
	 */
	public GenericException(Throwable t, Object[] msgParams){
		this(t);
		this.messageParams = msgParams;
	}
	
	/**
	 * Create with message code as argument
	 * @param messageCode message code
	 */
	public GenericException(MessageCode messageCode){
		super(messageCode.getKey());
		this.messageCode = messageCode;
	}
	
	/**
	 * Create with message params
	 * @param messageCode message code
	 * @param msgParams mesage params
	 */
	public GenericException(MessageCode messageCode, Object[] msgParams){
		this(messageCode);
		this.messageParams = msgParams;
	}

	/**
	 * Create with message code and cause
	 * @param messageCode
	 * @param cause
	 */
	public GenericException(MessageCode messageCode, Throwable cause){
		super(messageCode.getKey(), cause);
		this.messageCode = messageCode;
	}
	
	/**
	 * Create with message code, cause and message parameters
	 * @param messageCode message code
	 * @param cause cause
	 * @param msgParams message parameters
	 */
	public GenericException(MessageCode messageCode, Throwable cause, Object[] msgParams){
		this(messageCode, cause);
		this.messageParams = msgParams;
	}
	
	@Override
	public String getMessage() {
		return this.messageCode.getMessage(messageParams);
	}

	@Override
	public String getLocalizedMessage() {
		return this.messageCode.getMessage(messageParams);
	}

	/**
	 * Get message parameters
	 * @return message parameters
	 */
	public Object[] getMessageParams() {
		return messageParams;
	}
	
	
}