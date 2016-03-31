package com.vijet.docheadergenerator.exception;

/**
 * Runtime exception thrown when the number of arguments are less than the 3
 * @author Vijet Badigannavar
 */
public class InvalidSourceFolderException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidSourceFolderException()
	{
	}

	public InvalidSourceFolderException(String message)
	{
		super(message);
	}

	public InvalidSourceFolderException(Throwable cause)
	{
		super(cause);
	}

	public InvalidSourceFolderException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public InvalidSourceFolderException(String message, Throwable cause, 
                                       boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
