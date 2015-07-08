/*
 * Copyright (C) 2015 Denis Forveille titou10.titou10@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.titou10.jtb.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

/**
 * 
 * Ask for the delay for a new step of kind "pause"
 * 
 * @author Denis Forveille
 *
 */
public class ScriptsNewPauseDialog extends Dialog {

   private Integer delay;

   private Spinner delaySpinner;

   public ScriptsNewPauseDialog(Shell parentShell) {
      super(parentShell);
      setShellStyle(SWT.RESIZE | SWT.TITLE | SWT.APPLICATION_MODAL);
   }

   @Override
   protected void configureShell(Shell newShell) {
      super.configureShell(newShell);
      newShell.setText("Add a pause");
   }

   protected Point getInitialSize() {
      return new Point(220, 125);
   }

   @Override
   protected Control createDialogArea(Composite parent) {
      Composite container = (Composite) super.createDialogArea(parent);
      container.setLayout(new GridLayout(3, false));

      Label lblNewLabel1 = new Label(container, SWT.NONE);
      lblNewLabel1.setText("Delay");

      delaySpinner = new Spinner(container, SWT.BORDER);
      delaySpinner.setMinimum(1);
      delaySpinner.setMaximum(600);
      delaySpinner.setSelection(5);

      Label lblNewLabel2 = new Label(container, SWT.NONE);
      lblNewLabel2.setText("seconds");

      return container;
   }

   @Override
   protected void okPressed() {
      delay = delaySpinner.getSelection();
      super.okPressed();
   }

   // ----------------
   // Standard Getters
   // ----------------
   public Integer getDelay() {
      return delay;
   }

}
