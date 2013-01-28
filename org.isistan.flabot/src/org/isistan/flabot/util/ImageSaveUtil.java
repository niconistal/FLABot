/**
 * $Id: ImageSaveUtil.java,v 1.2 2006/04/01 03:51:15 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.util;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorPart;
import org.isistan.flabot.messages.Messages;

/**
 * Save format should be any of ... SWT.IMAGE_BMP, SWT.IMAGE_JPEG, SWT.IMAGE_ICO
 */
public class ImageSaveUtil {
	public static boolean save(IEditorPart editorPart, GraphicalViewer viewer,
			String saveFilePath, int format) {
		Assert.isNotNull(editorPart,
				"null editorPart passed to ImageSaveUtil::save"); //$NON-NLS-1$
		Assert.isNotNull(viewer, "null viewer passed to ImageSaveUtil::save"); //$NON-NLS-1$
		Assert.isNotNull(saveFilePath,
				"null saveFilePath passed to ImageSaveUtil::save"); //$NON-NLS-1$

		if (format != SWT.IMAGE_BMP && format != SWT.IMAGE_JPEG
				&& format != SWT.IMAGE_ICO)
			throw new IllegalArgumentException(Messages.getString("org.isistan.flabot.edit.ImageSaveUtil.exceptionName")); //$NON-NLS-1$

		try {
			saveEditorContentsAsImage(editorPart, viewer, saveFilePath, format);
		} catch (Exception ex) {
			MessageDialog.openError(editorPart.getEditorSite().getShell(),
					Messages.getString("org.isistan.flabot.edit.ImageSaveUtil.dialogName"), Messages.getString("org.isistan.flabot.edit.ImageSaveUtil.dialogDescription") + ex); //$NON-NLS-1$ //$NON-NLS-2$
			return false;
		}

		return true;
	}

	public static boolean save(IEditorPart editorPart, GraphicalViewer viewer) {
		Assert.isNotNull(editorPart,
				"null editorPart passed to ImageSaveUtil::save"); //$NON-NLS-1$
		Assert.isNotNull(viewer, "null viewer passed to ImageSaveUtil::save"); //$NON-NLS-1$

		String saveFilePath = getSaveFilePath(editorPart, viewer, -1);
		if (saveFilePath == null)
			return false;

		int format = SWT.IMAGE_JPEG;
		if (saveFilePath.endsWith(".jpeg")) //$NON-NLS-1$
			format = SWT.IMAGE_JPEG;
		else if (saveFilePath.endsWith(".bmp")) //$NON-NLS-1$
			format = SWT.IMAGE_BMP;
		else if (saveFilePath.endsWith(".ico")) //$NON-NLS-1$
			format = SWT.IMAGE_ICO;

		return save(editorPart, viewer, saveFilePath, format);
	}

	private static String getSaveFilePath(IEditorPart editorPart,
			GraphicalViewer viewer, int format) {
		FileDialog fileDialog = new FileDialog(editorPart.getEditorSite()
				.getShell(), SWT.SAVE);

		String[] filterExtensions = new String[] { 
				Messages.getString("org.isistan.flabot.util.ImageSaveUtil.jpeg"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.util.ImageSaveUtil.bmp"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.util.ImageSaveUtil.ico")}; //$NON-NLS-1$ 

		if (format == SWT.IMAGE_BMP)
			filterExtensions = new String[] { Messages.getString("org.isistan.flabot.util.ImageSaveUtil.bmp") }; //$NON-NLS-1$
		else if (format == SWT.IMAGE_JPEG)
			filterExtensions = new String[] { Messages.getString("org.isistan.flabot.util.ImageSaveUtil.jpeg") }; //$NON-NLS-1$
		else if (format == SWT.IMAGE_ICO)
			filterExtensions = new String[] { Messages.getString("org.isistan.flabot.util.ImageSaveUtil.ico") }; //$NON-NLS-1$
		fileDialog.setFilterExtensions(filterExtensions);

		return fileDialog.open();
	}

	@SuppressWarnings("deprecation") //$NON-NLS-1$
	private static void saveEditorContentsAsImage(IEditorPart editorPart,
			GraphicalViewer viewer, String saveFilePath, int format) {
		/*
		 * 1. First get the figure whose visuals we want to save as image. So we
		 * would like to save the rooteditpart which actually hosts all the
		 * printable layers.
		 * 
		 * NOTE: ScalableRootEditPart manages layers and is registered
		 * graphicalviewer's editpartregistry with the key LayerManager.ID ...
		 * well that is because ScalableRootEditPart manages all layers that are
		 * hosted on a FigureCanvas. Many layers exist for doing different
		 * things
		 */
		// Object layerManager =
		// viewer.getEditPartRegistry().get(LayerManager.ID);
		// ScalableFreeformRootEditPart rootEditPart =
		// (ScalableFreeformRootEditPart)layerManager;
		FigureCanvas figureCanvas = (FigureCanvas) viewer.getControl();
		// IFigure rootFigure =
		// ((LayerManager)rootEditPart).getLayer(LayerConstants.PRINTABLE_LAYERS);//rootEditPart.getFigure();
		IFigure rootFigure = figureCanvas.getContents();
		Rectangle rootFigureBounds = rootFigure.getBounds();

		/*
		 * 2. Now we want to get the GC associated with the control on which all
		 * figures are painted by SWTGraphics. For that first get the SWT
		 * Control associated with the viewer on which the rooteditpart is set
		 * as contents
		 */
		GC figureCanvasGC = new GC(figureCanvas);

		/*
		 * 3. Create a new Graphics for an Image onto which we want to paint
		 * rootFigure
		 */
		Image img = new Image(null, rootFigureBounds.width,
				rootFigureBounds.height);
		GC imageGC = new GC(img);
		imageGC.setTransform(new Transform(null, 1, 0, 0, 1,
				-rootFigureBounds.x, -rootFigureBounds.y));
		imageGC.setBackground(figureCanvasGC.getBackground());
		imageGC.setForeground(figureCanvasGC.getForeground());
		imageGC.setFont(figureCanvasGC.getFont());
		imageGC.setLineStyle(figureCanvasGC.getLineStyle());
		imageGC.setLineWidth(figureCanvasGC.getLineWidth());
		imageGC.setXORMode(figureCanvasGC.getXORMode());
		Graphics imgGraphics = new SWTGraphics(imageGC);

		/*
		 * 4. Draw rootFigure onto image. After that image will be ready for
		 * save
		 */
		rootFigure.paint(imgGraphics);

		/* 5. Save image */
		ImageData[] imgData = new ImageData[1];
		imgData[0] = img.getImageData();

		ImageLoader imgLoader = new ImageLoader();
		imgLoader.data = imgData;
		imgLoader.save(saveFilePath, format);

		/* release OS resources */
		figureCanvasGC.dispose();
		imageGC.dispose();
		img.dispose();
	}

	/**
	 * Print
	 * 
	 * @param editorPart
	 * @param viewer
	 */
	@SuppressWarnings("deprecation") //$NON-NLS-1$
	public static void print(IEditorPart editorPart, GraphicalViewer viewer,
			String printJobName) {
		PrintDialog dialog = new PrintDialog(editorPart.getSite().getShell());
		// Opens a dialog and let use user select the
		// target printer and configure various settings.
		PrinterData printerData = dialog.open();
		if (printerData != null) { // If a printer is selected
			// Creates a printer.
			Printer printer = new Printer(printerData);
			// Starts the print job.
			if (printer.startJob(printJobName)) {
				GC printerGC = new GC(printer);

				// Starts a new page.
				if (printer.startPage()) {
					
					org.eclipse.swt.graphics.Rectangle printableBounds =
						printer.getClientArea();
					
					// paint a footer
					printerGC.drawString(printJobName,
							100, printableBounds.height - 100);
					
					// Obtain the root figure and its bounds
					FigureCanvas figureCanvas = (FigureCanvas) viewer
							.getControl();
					IFigure rootFigure = figureCanvas.getContents();
					Rectangle rootFigureBounds = rootFigure.getBounds();

					// calculate scaling
					float scaleX = (float) printableBounds.width
							/ rootFigureBounds.width;
					float scaleY = (float) printableBounds.height
							/ rootFigureBounds.height;
					float scale = Math.min(scaleX, scaleY);

					// Calculate the scale factor between the screen resolution
					// and printer
					// resolution in order to correctly size the image for the
					// printer
					Point screenDPI = figureCanvas.getDisplay().getDPI();
					Point printerDPI = printer.getDPI();
					float scaleFactor = (float)printerDPI.x / screenDPI.x;
			        org.eclipse.swt.graphics.Rectangle trim =
			        	printer.computeTrim(0, 0, 0, 0);
					
					scale /= scaleFactor;
					scale *= 0.8f;

					// obtain the figure's gc
					GC figureCanvasGC = new GC(figureCanvas);
					
			
					// calculate x and y-axis displacement
					float dx = -rootFigureBounds.x;
					dx *= scale;
					dx -= trim.x;
					dx += 0.1f * trim.width;
					float dy = -rootFigureBounds.x;
					dy *= scale;
					dy -= trim.y;
					dy += 0.1f * trim.height;

					// setup printer's gc
					printerGC.setTransform(
							new Transform(null, scale, 0, 0, scale,
							dx, dy));
					printerGC.setBackground(figureCanvasGC.getBackground());
					printerGC.setForeground(figureCanvasGC.getForeground());
					printerGC.setFont(figureCanvasGC.getFont());
					printerGC.setLineStyle(figureCanvasGC.getLineStyle());
					printerGC.setLineWidth(figureCanvasGC.getLineWidth());
					printerGC.setXORMode(figureCanvasGC.getXORMode());
					Graphics printerGraphics = new SWTGraphics(printerGC);

					// paint the diagram on the printer graphics
					rootFigure.paint(printerGraphics);

					// Finishes the page.
					printer.endPage();

					figureCanvasGC.dispose();
					printerGraphics.dispose();
				}
				printerGC.dispose();
				// Ends the job.
				printer.endJob();
			}
			// Disposes the printer object after use.
			printer.dispose();
		}
	}
}