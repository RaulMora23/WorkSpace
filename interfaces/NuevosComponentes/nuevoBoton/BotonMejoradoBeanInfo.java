/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/BeanInfo.java to edit this template
 */
package nuevoBoton;

import java.beans.*;

/**
 *
 * @author Raul Mora
 */
//Esta clase sirve para modificar las propiedades de la clase BotonMejorado, en concreto lo relativo a la nueva propiedad degradado
public class BotonMejoradoBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( nuevoBoton.BotonMejorado.class , null ); // NOI18N//GEN-HEADEREND:BeanDescriptor
        // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_action = 1;
    private static final int PROPERTY_actionCommand = 2;
    private static final int PROPERTY_actionListeners = 3;
    private static final int PROPERTY_actionMap = 4;
    private static final int PROPERTY_alignmentX = 5;
    private static final int PROPERTY_alignmentY = 6;
    private static final int PROPERTY_ancestorListeners = 7;
    private static final int PROPERTY_autoscrolls = 8;
    private static final int PROPERTY_background = 9;
    private static final int PROPERTY_backgroundSet = 10;
    private static final int PROPERTY_baselineResizeBehavior = 11;
    private static final int PROPERTY_border = 12;
    private static final int PROPERTY_borderPainted = 13;
    private static final int PROPERTY_bounds = 14;
    private static final int PROPERTY_changeListeners = 15;
    private static final int PROPERTY_circular = 16;
    private static final int PROPERTY_colorModel = 17;
    private static final int PROPERTY_component = 18;
    private static final int PROPERTY_componentCount = 19;
    private static final int PROPERTY_componentListeners = 20;
    private static final int PROPERTY_componentOrientation = 21;
    private static final int PROPERTY_componentPopupMenu = 22;
    private static final int PROPERTY_components = 23;
    private static final int PROPERTY_containerListeners = 24;
    private static final int PROPERTY_contentAreaFilled = 25;
    private static final int PROPERTY_cursor = 26;
    private static final int PROPERTY_cursorSet = 27;
    private static final int PROPERTY_debugGraphicsOptions = 28;
    private static final int PROPERTY_defaultButton = 29;
    private static final int PROPERTY_defaultCapable = 30;
    private static final int PROPERTY_degradado = 31;
    private static final int PROPERTY_disabledIcon = 32;
    private static final int PROPERTY_disabledSelectedIcon = 33;
    private static final int PROPERTY_displayable = 34;
    private static final int PROPERTY_displayedMnemonicIndex = 35;
    private static final int PROPERTY_doubleBuffered = 36;
    private static final int PROPERTY_dropTarget = 37;
    private static final int PROPERTY_enabled = 38;
    private static final int PROPERTY_focusable = 39;
    private static final int PROPERTY_focusCycleRoot = 40;
    private static final int PROPERTY_focusCycleRootAncestor = 41;
    private static final int PROPERTY_focusListeners = 42;
    private static final int PROPERTY_focusOwner = 43;
    private static final int PROPERTY_focusPainted = 44;
    private static final int PROPERTY_focusTraversable = 45;
    private static final int PROPERTY_focusTraversalKeys = 46;
    private static final int PROPERTY_focusTraversalKeysEnabled = 47;
    private static final int PROPERTY_focusTraversalPolicy = 48;
    private static final int PROPERTY_focusTraversalPolicyProvider = 49;
    private static final int PROPERTY_focusTraversalPolicySet = 50;
    private static final int PROPERTY_fondo = 51;
    private static final int PROPERTY_font = 52;
    private static final int PROPERTY_fontSet = 53;
    private static final int PROPERTY_foreground = 54;
    private static final int PROPERTY_foregroundSet = 55;
    private static final int PROPERTY_graphics = 56;
    private static final int PROPERTY_graphicsConfiguration = 57;
    private static final int PROPERTY_height = 58;
    private static final int PROPERTY_hideActionText = 59;
    private static final int PROPERTY_hierarchyBoundsListeners = 60;
    private static final int PROPERTY_hierarchyListeners = 61;
    private static final int PROPERTY_horizontalAlignment = 62;
    private static final int PROPERTY_horizontalTextPosition = 63;
    private static final int PROPERTY_icon = 64;
    private static final int PROPERTY_iconTextGap = 65;
    private static final int PROPERTY_ignoreRepaint = 66;
    private static final int PROPERTY_inheritsPopupMenu = 67;
    private static final int PROPERTY_inputContext = 68;
    private static final int PROPERTY_inputMap = 69;
    private static final int PROPERTY_inputMethodListeners = 70;
    private static final int PROPERTY_inputMethodRequests = 71;
    private static final int PROPERTY_inputVerifier = 72;
    private static final int PROPERTY_insets = 73;
    private static final int PROPERTY_itemListeners = 74;
    private static final int PROPERTY_keyListeners = 75;
    private static final int PROPERTY_label = 76;
    private static final int PROPERTY_layout = 77;
    private static final int PROPERTY_lightweight = 78;
    private static final int PROPERTY_locale = 79;
    private static final int PROPERTY_location = 80;
    private static final int PROPERTY_locationOnScreen = 81;
    private static final int PROPERTY_managingFocus = 82;
    private static final int PROPERTY_margin = 83;
    private static final int PROPERTY_maximumSize = 84;
    private static final int PROPERTY_maximumSizeSet = 85;
    private static final int PROPERTY_minimumSize = 86;
    private static final int PROPERTY_minimumSizeSet = 87;
    private static final int PROPERTY_mixingCutoutShape = 88;
    private static final int PROPERTY_mnemonic = 89;
    private static final int PROPERTY_model = 90;
    private static final int PROPERTY_mouseListeners = 91;
    private static final int PROPERTY_mouseMotionListeners = 92;
    private static final int PROPERTY_mousePosition = 93;
    private static final int PROPERTY_mouseWheelListeners = 94;
    private static final int PROPERTY_multiClickThreshhold = 95;
    private static final int PROPERTY_name = 96;
    private static final int PROPERTY_nextFocusableComponent = 97;
    private static final int PROPERTY_opaque = 98;
    private static final int PROPERTY_optimizedDrawingEnabled = 99;
    private static final int PROPERTY_paintingForPrint = 100;
    private static final int PROPERTY_paintingTile = 101;
    private static final int PROPERTY_parent = 102;
    private static final int PROPERTY_preferredSize = 103;
    private static final int PROPERTY_preferredSizeSet = 104;
    private static final int PROPERTY_pressedIcon = 105;
    private static final int PROPERTY_propertyChangeListeners = 106;
    private static final int PROPERTY_registeredKeyStrokes = 107;
    private static final int PROPERTY_requestFocusEnabled = 108;
    private static final int PROPERTY_rolloverEnabled = 109;
    private static final int PROPERTY_rolloverIcon = 110;
    private static final int PROPERTY_rolloverSelectedIcon = 111;
    private static final int PROPERTY_rootPane = 112;
    private static final int PROPERTY_selected = 113;
    private static final int PROPERTY_selectedIcon = 114;
    private static final int PROPERTY_selectedObjects = 115;
    private static final int PROPERTY_showing = 116;
    private static final int PROPERTY_size = 117;
    private static final int PROPERTY_text = 118;
    private static final int PROPERTY_toolkit = 119;
    private static final int PROPERTY_toolTipText = 120;
    private static final int PROPERTY_topLevelAncestor = 121;
    private static final int PROPERTY_transferHandler = 122;
    private static final int PROPERTY_treeLock = 123;
    private static final int PROPERTY_UI = 124;
    private static final int PROPERTY_UIClassID = 125;
    private static final int PROPERTY_valid = 126;
    private static final int PROPERTY_validateRoot = 127;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 128;
    private static final int PROPERTY_verticalAlignment = 129;
    private static final int PROPERTY_verticalTextPosition = 130;
    private static final int PROPERTY_vetoableChangeListeners = 131;
    private static final int PROPERTY_visible = 132;
    private static final int PROPERTY_visibleRect = 133;
    private static final int PROPERTY_width = 134;
    private static final int PROPERTY_x = 135;
    private static final int PROPERTY_y = 136;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[137];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", nuevoBoton.BotonMejorado.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_action] = new PropertyDescriptor ( "action", nuevoBoton.BotonMejorado.class, "getAction", "setAction" ); // NOI18N
            properties[PROPERTY_actionCommand] = new PropertyDescriptor ( "actionCommand", nuevoBoton.BotonMejorado.class, "getActionCommand", "setActionCommand" ); // NOI18N
            properties[PROPERTY_actionListeners] = new PropertyDescriptor ( "actionListeners", nuevoBoton.BotonMejorado.class, "getActionListeners", null ); // NOI18N
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", nuevoBoton.BotonMejorado.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", nuevoBoton.BotonMejorado.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", nuevoBoton.BotonMejorado.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", nuevoBoton.BotonMejorado.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", nuevoBoton.BotonMejorado.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", nuevoBoton.BotonMejorado.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", nuevoBoton.BotonMejorado.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", nuevoBoton.BotonMejorado.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", nuevoBoton.BotonMejorado.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_borderPainted] = new PropertyDescriptor ( "borderPainted", nuevoBoton.BotonMejorado.class, "isBorderPainted", "setBorderPainted" ); // NOI18N
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", nuevoBoton.BotonMejorado.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_changeListeners] = new PropertyDescriptor ( "changeListeners", nuevoBoton.BotonMejorado.class, "getChangeListeners", null ); // NOI18N
            properties[PROPERTY_circular] = new PropertyDescriptor ( "circular", nuevoBoton.BotonMejorado.class, "isCircular", "setCircular" ); // NOI18N
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", nuevoBoton.BotonMejorado.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", nuevoBoton.BotonMejorado.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", nuevoBoton.BotonMejorado.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", nuevoBoton.BotonMejorado.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", nuevoBoton.BotonMejorado.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", nuevoBoton.BotonMejorado.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", nuevoBoton.BotonMejorado.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", nuevoBoton.BotonMejorado.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_contentAreaFilled] = new PropertyDescriptor ( "contentAreaFilled", nuevoBoton.BotonMejorado.class, "isContentAreaFilled", "setContentAreaFilled" ); // NOI18N
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", nuevoBoton.BotonMejorado.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", nuevoBoton.BotonMejorado.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", nuevoBoton.BotonMejorado.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_defaultButton] = new PropertyDescriptor ( "defaultButton", nuevoBoton.BotonMejorado.class, "isDefaultButton", null ); // NOI18N
            properties[PROPERTY_defaultCapable] = new PropertyDescriptor ( "defaultCapable", nuevoBoton.BotonMejorado.class, "isDefaultCapable", "setDefaultCapable" ); // NOI18N
            properties[PROPERTY_degradado] = new PropertyDescriptor ( "degradado", nuevoBoton.BotonMejorado.class, "getDegradado", "setDegradado" ); // NOI18N
            properties[PROPERTY_degradado].setPropertyEditorClass ( nuevoBoton.DegradadoPropertyEditor.class );
            properties[PROPERTY_disabledIcon] = new PropertyDescriptor ( "disabledIcon", nuevoBoton.BotonMejorado.class, "getDisabledIcon", "setDisabledIcon" ); // NOI18N
            properties[PROPERTY_disabledSelectedIcon] = new PropertyDescriptor ( "disabledSelectedIcon", nuevoBoton.BotonMejorado.class, "getDisabledSelectedIcon", "setDisabledSelectedIcon" ); // NOI18N
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", nuevoBoton.BotonMejorado.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_displayedMnemonicIndex] = new PropertyDescriptor ( "displayedMnemonicIndex", nuevoBoton.BotonMejorado.class, "getDisplayedMnemonicIndex", "setDisplayedMnemonicIndex" ); // NOI18N
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", nuevoBoton.BotonMejorado.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", nuevoBoton.BotonMejorado.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", nuevoBoton.BotonMejorado.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", nuevoBoton.BotonMejorado.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", nuevoBoton.BotonMejorado.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", nuevoBoton.BotonMejorado.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", nuevoBoton.BotonMejorado.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", nuevoBoton.BotonMejorado.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusPainted] = new PropertyDescriptor ( "focusPainted", nuevoBoton.BotonMejorado.class, "isFocusPainted", "setFocusPainted" ); // NOI18N
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", nuevoBoton.BotonMejorado.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", nuevoBoton.BotonMejorado.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", nuevoBoton.BotonMejorado.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", nuevoBoton.BotonMejorado.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", nuevoBoton.BotonMejorado.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", nuevoBoton.BotonMejorado.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_fondo] = new PropertyDescriptor ( "fondo", nuevoBoton.BotonMejorado.class, "getFondo", "setFondo" ); // NOI18N
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", nuevoBoton.BotonMejorado.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", nuevoBoton.BotonMejorado.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", nuevoBoton.BotonMejorado.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", nuevoBoton.BotonMejorado.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", nuevoBoton.BotonMejorado.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", nuevoBoton.BotonMejorado.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", nuevoBoton.BotonMejorado.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_hideActionText] = new PropertyDescriptor ( "hideActionText", nuevoBoton.BotonMejorado.class, "getHideActionText", "setHideActionText" ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", nuevoBoton.BotonMejorado.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", nuevoBoton.BotonMejorado.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_horizontalAlignment] = new PropertyDescriptor ( "horizontalAlignment", nuevoBoton.BotonMejorado.class, "getHorizontalAlignment", "setHorizontalAlignment" ); // NOI18N
            properties[PROPERTY_horizontalTextPosition] = new PropertyDescriptor ( "horizontalTextPosition", nuevoBoton.BotonMejorado.class, "getHorizontalTextPosition", "setHorizontalTextPosition" ); // NOI18N
            properties[PROPERTY_icon] = new PropertyDescriptor ( "icon", nuevoBoton.BotonMejorado.class, "getIcon", "setIcon" ); // NOI18N
            properties[PROPERTY_iconTextGap] = new PropertyDescriptor ( "iconTextGap", nuevoBoton.BotonMejorado.class, "getIconTextGap", "setIconTextGap" ); // NOI18N
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", nuevoBoton.BotonMejorado.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", nuevoBoton.BotonMejorado.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", nuevoBoton.BotonMejorado.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", nuevoBoton.BotonMejorado.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", nuevoBoton.BotonMejorado.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", nuevoBoton.BotonMejorado.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", nuevoBoton.BotonMejorado.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", nuevoBoton.BotonMejorado.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_itemListeners] = new PropertyDescriptor ( "itemListeners", nuevoBoton.BotonMejorado.class, "getItemListeners", null ); // NOI18N
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", nuevoBoton.BotonMejorado.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_label] = new PropertyDescriptor ( "label", nuevoBoton.BotonMejorado.class, "getLabel", "setLabel" ); // NOI18N
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", nuevoBoton.BotonMejorado.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", nuevoBoton.BotonMejorado.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", nuevoBoton.BotonMejorado.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", nuevoBoton.BotonMejorado.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", nuevoBoton.BotonMejorado.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", nuevoBoton.BotonMejorado.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_margin] = new PropertyDescriptor ( "margin", nuevoBoton.BotonMejorado.class, "getMargin", "setMargin" ); // NOI18N
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", nuevoBoton.BotonMejorado.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", nuevoBoton.BotonMejorado.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", nuevoBoton.BotonMejorado.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", nuevoBoton.BotonMejorado.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_mixingCutoutShape] = new PropertyDescriptor ( "mixingCutoutShape", nuevoBoton.BotonMejorado.class, null, "setMixingCutoutShape" ); // NOI18N
            properties[PROPERTY_mnemonic] = new PropertyDescriptor ( "mnemonic", nuevoBoton.BotonMejorado.class, null, "setMnemonic" ); // NOI18N
            properties[PROPERTY_model] = new PropertyDescriptor ( "model", nuevoBoton.BotonMejorado.class, "getModel", "setModel" ); // NOI18N
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", nuevoBoton.BotonMejorado.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", nuevoBoton.BotonMejorado.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", nuevoBoton.BotonMejorado.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", nuevoBoton.BotonMejorado.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_multiClickThreshhold] = new PropertyDescriptor ( "multiClickThreshhold", nuevoBoton.BotonMejorado.class, "getMultiClickThreshhold", "setMultiClickThreshhold" ); // NOI18N
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", nuevoBoton.BotonMejorado.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", nuevoBoton.BotonMejorado.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", nuevoBoton.BotonMejorado.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", nuevoBoton.BotonMejorado.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", nuevoBoton.BotonMejorado.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", nuevoBoton.BotonMejorado.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", nuevoBoton.BotonMejorado.class, "getParent", null ); // NOI18N
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", nuevoBoton.BotonMejorado.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", nuevoBoton.BotonMejorado.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_pressedIcon] = new PropertyDescriptor ( "pressedIcon", nuevoBoton.BotonMejorado.class, "getPressedIcon", "setPressedIcon" ); // NOI18N
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", nuevoBoton.BotonMejorado.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", nuevoBoton.BotonMejorado.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", nuevoBoton.BotonMejorado.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_rolloverEnabled] = new PropertyDescriptor ( "rolloverEnabled", nuevoBoton.BotonMejorado.class, "isRolloverEnabled", "setRolloverEnabled" ); // NOI18N
            properties[PROPERTY_rolloverIcon] = new PropertyDescriptor ( "rolloverIcon", nuevoBoton.BotonMejorado.class, "getRolloverIcon", "setRolloverIcon" ); // NOI18N
            properties[PROPERTY_rolloverSelectedIcon] = new PropertyDescriptor ( "rolloverSelectedIcon", nuevoBoton.BotonMejorado.class, "getRolloverSelectedIcon", "setRolloverSelectedIcon" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", nuevoBoton.BotonMejorado.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_selected] = new PropertyDescriptor ( "selected", nuevoBoton.BotonMejorado.class, "isSelected", "setSelected" ); // NOI18N
            properties[PROPERTY_selectedIcon] = new PropertyDescriptor ( "selectedIcon", nuevoBoton.BotonMejorado.class, "getSelectedIcon", "setSelectedIcon" ); // NOI18N
            properties[PROPERTY_selectedObjects] = new PropertyDescriptor ( "selectedObjects", nuevoBoton.BotonMejorado.class, "getSelectedObjects", null ); // NOI18N
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", nuevoBoton.BotonMejorado.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", nuevoBoton.BotonMejorado.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_text] = new PropertyDescriptor ( "text", nuevoBoton.BotonMejorado.class, "getText", "setText" ); // NOI18N
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", nuevoBoton.BotonMejorado.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", nuevoBoton.BotonMejorado.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", nuevoBoton.BotonMejorado.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", nuevoBoton.BotonMejorado.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", nuevoBoton.BotonMejorado.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", nuevoBoton.BotonMejorado.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", nuevoBoton.BotonMejorado.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", nuevoBoton.BotonMejorado.class, "isValid", null ); // NOI18N
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", nuevoBoton.BotonMejorado.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", nuevoBoton.BotonMejorado.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_verticalAlignment] = new PropertyDescriptor ( "verticalAlignment", nuevoBoton.BotonMejorado.class, "getVerticalAlignment", "setVerticalAlignment" ); // NOI18N
            properties[PROPERTY_verticalTextPosition] = new PropertyDescriptor ( "verticalTextPosition", nuevoBoton.BotonMejorado.class, "getVerticalTextPosition", "setVerticalTextPosition" ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", nuevoBoton.BotonMejorado.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", nuevoBoton.BotonMejorado.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", nuevoBoton.BotonMejorado.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", nuevoBoton.BotonMejorado.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", nuevoBoton.BotonMejorado.class, "getX", null ); // NOI18N
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", nuevoBoton.BotonMejorado.class, "getY", null ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties
        // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties

    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_actionListener = 0;
    private static final int EVENT_ancestorListener = 1;
    private static final int EVENT_changeListener = 2;
    private static final int EVENT_componentListener = 3;
    private static final int EVENT_containerListener = 4;
    private static final int EVENT_focusListener = 5;
    private static final int EVENT_hierarchyBoundsListener = 6;
    private static final int EVENT_hierarchyListener = 7;
    private static final int EVENT_inputMethodListener = 8;
    private static final int EVENT_itemListener = 9;
    private static final int EVENT_keyListener = 10;
    private static final int EVENT_mouseListener = 11;
    private static final int EVENT_mouseMotionListener = 12;
    private static final int EVENT_mouseWheelListener = 13;
    private static final int EVENT_propertyChangeListener = 14;
    private static final int EVENT_vetoableChangeListener = 15;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[16];
    
        try {
            eventSets[EVENT_actionListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "actionListener", java.awt.event.ActionListener.class, new String[] {"actionPerformed"}, "addActionListener", "removeActionListener" ); // NOI18N
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_changeListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "changeListener", javax.swing.event.ChangeListener.class, new String[] {"stateChanged"}, "addChangeListener", "removeChangeListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_itemListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "itemListener", java.awt.event.ItemListener.class, new String[] {"itemStateChanged"}, "addItemListener", "removeItemListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( nuevoBoton.BotonMejorado.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Events
        // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events

    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_action0 = 0;
    private static final int METHOD_add1 = 1;
    private static final int METHOD_add2 = 2;
    private static final int METHOD_add3 = 3;
    private static final int METHOD_add4 = 4;
    private static final int METHOD_add5 = 5;
    private static final int METHOD_add6 = 6;
    private static final int METHOD_addNotify7 = 7;
    private static final int METHOD_addPropertyChangeListener8 = 8;
    private static final int METHOD_applyComponentOrientation9 = 9;
    private static final int METHOD_areFocusTraversalKeysSet10 = 10;
    private static final int METHOD_bounds11 = 11;
    private static final int METHOD_checkImage12 = 12;
    private static final int METHOD_checkImage13 = 13;
    private static final int METHOD_computeVisibleRect14 = 14;
    private static final int METHOD_contains15 = 15;
    private static final int METHOD_contains16 = 16;
    private static final int METHOD_countComponents17 = 17;
    private static final int METHOD_createImage18 = 18;
    private static final int METHOD_createImage19 = 19;
    private static final int METHOD_createToolTip20 = 20;
    private static final int METHOD_createVolatileImage21 = 21;
    private static final int METHOD_createVolatileImage22 = 22;
    private static final int METHOD_deliverEvent23 = 23;
    private static final int METHOD_disable24 = 24;
    private static final int METHOD_dispatchEvent25 = 25;
    private static final int METHOD_doClick26 = 26;
    private static final int METHOD_doClick27 = 27;
    private static final int METHOD_doLayout28 = 28;
    private static final int METHOD_enable29 = 29;
    private static final int METHOD_enable30 = 30;
    private static final int METHOD_enableInputMethods31 = 31;
    private static final int METHOD_findComponentAt32 = 32;
    private static final int METHOD_findComponentAt33 = 33;
    private static final int METHOD_firePropertyChange34 = 34;
    private static final int METHOD_firePropertyChange35 = 35;
    private static final int METHOD_firePropertyChange36 = 36;
    private static final int METHOD_firePropertyChange37 = 37;
    private static final int METHOD_firePropertyChange38 = 38;
    private static final int METHOD_firePropertyChange39 = 39;
    private static final int METHOD_firePropertyChange40 = 40;
    private static final int METHOD_firePropertyChange41 = 41;
    private static final int METHOD_getActionForKeyStroke42 = 42;
    private static final int METHOD_getBaseline43 = 43;
    private static final int METHOD_getBounds44 = 44;
    private static final int METHOD_getClientProperty45 = 45;
    private static final int METHOD_getComponentAt46 = 46;
    private static final int METHOD_getComponentAt47 = 47;
    private static final int METHOD_getComponentZOrder48 = 48;
    private static final int METHOD_getConditionForKeyStroke49 = 49;
    private static final int METHOD_getDefaultLocale50 = 50;
    private static final int METHOD_getFocusTraversalKeys51 = 51;
    private static final int METHOD_getFontMetrics52 = 52;
    private static final int METHOD_getInsets53 = 53;
    private static final int METHOD_getListeners54 = 54;
    private static final int METHOD_getLocation55 = 55;
    private static final int METHOD_getMnemonic56 = 56;
    private static final int METHOD_getMousePosition57 = 57;
    private static final int METHOD_getPopupLocation58 = 58;
    private static final int METHOD_getPropertyChangeListeners59 = 59;
    private static final int METHOD_getSerialversionuid60 = 60;
    private static final int METHOD_getSize61 = 61;
    private static final int METHOD_getToolTipLocation62 = 62;
    private static final int METHOD_getToolTipText63 = 63;
    private static final int METHOD_gotFocus64 = 64;
    private static final int METHOD_grabFocus65 = 65;
    private static final int METHOD_handleEvent66 = 66;
    private static final int METHOD_hasFocus67 = 67;
    private static final int METHOD_hide68 = 68;
    private static final int METHOD_imageUpdate69 = 69;
    private static final int METHOD_insets70 = 70;
    private static final int METHOD_inside71 = 71;
    private static final int METHOD_invalidate72 = 72;
    private static final int METHOD_isAncestorOf73 = 73;
    private static final int METHOD_isFocusCycleRoot74 = 74;
    private static final int METHOD_isLightweightComponent75 = 75;
    private static final int METHOD_keyDown76 = 76;
    private static final int METHOD_keyUp77 = 77;
    private static final int METHOD_layout78 = 78;
    private static final int METHOD_list79 = 79;
    private static final int METHOD_list80 = 80;
    private static final int METHOD_list81 = 81;
    private static final int METHOD_list82 = 82;
    private static final int METHOD_list83 = 83;
    private static final int METHOD_locate84 = 84;
    private static final int METHOD_location85 = 85;
    private static final int METHOD_lostFocus86 = 86;
    private static final int METHOD_minimumSize87 = 87;
    private static final int METHOD_mouseDown88 = 88;
    private static final int METHOD_mouseDrag89 = 89;
    private static final int METHOD_mouseEnter90 = 90;
    private static final int METHOD_mouseExit91 = 91;
    private static final int METHOD_mouseMove92 = 92;
    private static final int METHOD_mouseUp93 = 93;
    private static final int METHOD_move94 = 94;
    private static final int METHOD_nextFocus95 = 95;
    private static final int METHOD_paint96 = 96;
    private static final int METHOD_paintAll97 = 97;
    private static final int METHOD_paintComponents98 = 98;
    private static final int METHOD_paintImmediately99 = 99;
    private static final int METHOD_paintImmediately100 = 100;
    private static final int METHOD_postEvent101 = 101;
    private static final int METHOD_preferredSize102 = 102;
    private static final int METHOD_prepareImage103 = 103;
    private static final int METHOD_prepareImage104 = 104;
    private static final int METHOD_print105 = 105;
    private static final int METHOD_printAll106 = 106;
    private static final int METHOD_printComponents107 = 107;
    private static final int METHOD_putClientProperty108 = 108;
    private static final int METHOD_registerKeyboardAction109 = 109;
    private static final int METHOD_registerKeyboardAction110 = 110;
    private static final int METHOD_remove111 = 111;
    private static final int METHOD_remove112 = 112;
    private static final int METHOD_remove113 = 113;
    private static final int METHOD_removeAll114 = 114;
    private static final int METHOD_removeNotify115 = 115;
    private static final int METHOD_removePropertyChangeListener116 = 116;
    private static final int METHOD_repaint117 = 117;
    private static final int METHOD_repaint118 = 118;
    private static final int METHOD_repaint119 = 119;
    private static final int METHOD_repaint120 = 120;
    private static final int METHOD_repaint121 = 121;
    private static final int METHOD_requestDefaultFocus122 = 122;
    private static final int METHOD_requestFocus123 = 123;
    private static final int METHOD_requestFocus124 = 124;
    private static final int METHOD_requestFocus125 = 125;
    private static final int METHOD_requestFocusInWindow126 = 126;
    private static final int METHOD_requestFocusInWindow127 = 127;
    private static final int METHOD_resetKeyboardActions128 = 128;
    private static final int METHOD_reshape129 = 129;
    private static final int METHOD_resize130 = 130;
    private static final int METHOD_resize131 = 131;
    private static final int METHOD_revalidate132 = 132;
    private static final int METHOD_scrollRectToVisible133 = 133;
    private static final int METHOD_setBounds134 = 134;
    private static final int METHOD_setComponentZOrder135 = 135;
    private static final int METHOD_setDefaultLocale136 = 136;
    private static final int METHOD_setMnemonic137 = 137;
    private static final int METHOD_show138 = 138;
    private static final int METHOD_show139 = 139;
    private static final int METHOD_size140 = 140;
    private static final int METHOD_toString141 = 141;
    private static final int METHOD_transferFocus142 = 142;
    private static final int METHOD_transferFocusBackward143 = 143;
    private static final int METHOD_transferFocusDownCycle144 = 144;
    private static final int METHOD_transferFocusUpCycle145 = 145;
    private static final int METHOD_unregisterKeyboardAction146 = 146;
    private static final int METHOD_update147 = 147;
    private static final int METHOD_updateUI148 = 148;
    private static final int METHOD_validate149 = 149;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[150];
    
        try {
            methods[METHOD_action0] = new MethodDescriptor(java.awt.Component.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_action0].setDisplayName ( "" );
            methods[METHOD_add1] = new MethodDescriptor(java.awt.Component.class.getMethod("add", new Class[] {java.awt.PopupMenu.class})); // NOI18N
            methods[METHOD_add1].setDisplayName ( "" );
            methods[METHOD_add2] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_add2].setDisplayName ( "" );
            methods[METHOD_add3] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.lang.String.class, java.awt.Component.class})); // NOI18N
            methods[METHOD_add3].setDisplayName ( "" );
            methods[METHOD_add4] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_add4].setDisplayName ( "" );
            methods[METHOD_add5] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_add5].setDisplayName ( "" );
            methods[METHOD_add6] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class, int.class})); // NOI18N
            methods[METHOD_add6].setDisplayName ( "" );
            methods[METHOD_addNotify7] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("addNotify", new Class[] {})); // NOI18N
            methods[METHOD_addNotify7].setDisplayName ( "" );
            methods[METHOD_addPropertyChangeListener8] = new MethodDescriptor(java.awt.Container.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_addPropertyChangeListener8].setDisplayName ( "" );
            methods[METHOD_applyComponentOrientation9] = new MethodDescriptor(java.awt.Container.class.getMethod("applyComponentOrientation", new Class[] {java.awt.ComponentOrientation.class})); // NOI18N
            methods[METHOD_applyComponentOrientation9].setDisplayName ( "" );
            methods[METHOD_areFocusTraversalKeysSet10] = new MethodDescriptor(java.awt.Container.class.getMethod("areFocusTraversalKeysSet", new Class[] {int.class})); // NOI18N
            methods[METHOD_areFocusTraversalKeysSet10].setDisplayName ( "" );
            methods[METHOD_bounds11] = new MethodDescriptor(java.awt.Component.class.getMethod("bounds", new Class[] {})); // NOI18N
            methods[METHOD_bounds11].setDisplayName ( "" );
            methods[METHOD_checkImage12] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage12].setDisplayName ( "" );
            methods[METHOD_checkImage13] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage13].setDisplayName ( "" );
            methods[METHOD_computeVisibleRect14] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("computeVisibleRect", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_computeVisibleRect14].setDisplayName ( "" );
            methods[METHOD_contains15] = new MethodDescriptor(java.awt.Component.class.getMethod("contains", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_contains15].setDisplayName ( "" );
            methods[METHOD_contains16] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("contains", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_contains16].setDisplayName ( "" );
            methods[METHOD_countComponents17] = new MethodDescriptor(java.awt.Container.class.getMethod("countComponents", new Class[] {})); // NOI18N
            methods[METHOD_countComponents17].setDisplayName ( "" );
            methods[METHOD_createImage18] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class})); // NOI18N
            methods[METHOD_createImage18].setDisplayName ( "" );
            methods[METHOD_createImage19] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createImage19].setDisplayName ( "" );
            methods[METHOD_createToolTip20] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("createToolTip", new Class[] {})); // NOI18N
            methods[METHOD_createToolTip20].setDisplayName ( "" );
            methods[METHOD_createVolatileImage21] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createVolatileImage21].setDisplayName ( "" );
            methods[METHOD_createVolatileImage22] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class, java.awt.ImageCapabilities.class})); // NOI18N
            methods[METHOD_createVolatileImage22].setDisplayName ( "" );
            methods[METHOD_deliverEvent23] = new MethodDescriptor(java.awt.Container.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_deliverEvent23].setDisplayName ( "" );
            methods[METHOD_disable24] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("disable", new Class[] {})); // NOI18N
            methods[METHOD_disable24].setDisplayName ( "" );
            methods[METHOD_dispatchEvent25] = new MethodDescriptor(java.awt.Component.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class})); // NOI18N
            methods[METHOD_dispatchEvent25].setDisplayName ( "" );
            methods[METHOD_doClick26] = new MethodDescriptor(javax.swing.AbstractButton.class.getMethod("doClick", new Class[] {})); // NOI18N
            methods[METHOD_doClick26].setDisplayName ( "" );
            methods[METHOD_doClick27] = new MethodDescriptor(javax.swing.AbstractButton.class.getMethod("doClick", new Class[] {int.class})); // NOI18N
            methods[METHOD_doClick27].setDisplayName ( "" );
            methods[METHOD_doLayout28] = new MethodDescriptor(java.awt.Container.class.getMethod("doLayout", new Class[] {})); // NOI18N
            methods[METHOD_doLayout28].setDisplayName ( "" );
            methods[METHOD_enable29] = new MethodDescriptor(java.awt.Component.class.getMethod("enable", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enable29].setDisplayName ( "" );
            methods[METHOD_enable30] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("enable", new Class[] {})); // NOI18N
            methods[METHOD_enable30].setDisplayName ( "" );
            methods[METHOD_enableInputMethods31] = new MethodDescriptor(java.awt.Component.class.getMethod("enableInputMethods", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enableInputMethods31].setDisplayName ( "" );
            methods[METHOD_findComponentAt32] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_findComponentAt32].setDisplayName ( "" );
            methods[METHOD_findComponentAt33] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_findComponentAt33].setDisplayName ( "" );
            methods[METHOD_firePropertyChange34] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, byte.class, byte.class})); // NOI18N
            methods[METHOD_firePropertyChange34].setDisplayName ( "" );
            methods[METHOD_firePropertyChange35] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, short.class, short.class})); // NOI18N
            methods[METHOD_firePropertyChange35].setDisplayName ( "" );
            methods[METHOD_firePropertyChange36] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, long.class, long.class})); // NOI18N
            methods[METHOD_firePropertyChange36].setDisplayName ( "" );
            methods[METHOD_firePropertyChange37] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, float.class, float.class})); // NOI18N
            methods[METHOD_firePropertyChange37].setDisplayName ( "" );
            methods[METHOD_firePropertyChange38] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, double.class, double.class})); // NOI18N
            methods[METHOD_firePropertyChange38].setDisplayName ( "" );
            methods[METHOD_firePropertyChange39] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, boolean.class, boolean.class})); // NOI18N
            methods[METHOD_firePropertyChange39].setDisplayName ( "" );
            methods[METHOD_firePropertyChange40] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, int.class, int.class})); // NOI18N
            methods[METHOD_firePropertyChange40].setDisplayName ( "" );
            methods[METHOD_firePropertyChange41] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, char.class, char.class})); // NOI18N
            methods[METHOD_firePropertyChange41].setDisplayName ( "" );
            methods[METHOD_getActionForKeyStroke42] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getActionForKeyStroke", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_getActionForKeyStroke42].setDisplayName ( "" );
            methods[METHOD_getBaseline43] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getBaseline", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getBaseline43].setDisplayName ( "" );
            methods[METHOD_getBounds44] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_getBounds44].setDisplayName ( "" );
            methods[METHOD_getClientProperty45] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getClientProperty", new Class[] {java.lang.Object.class})); // NOI18N
            methods[METHOD_getClientProperty45].setDisplayName ( "" );
            methods[METHOD_getComponentAt46] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getComponentAt46].setDisplayName ( "" );
            methods[METHOD_getComponentAt47] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getComponentAt47].setDisplayName ( "" );
            methods[METHOD_getComponentZOrder48] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentZOrder", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_getComponentZOrder48].setDisplayName ( "" );
            methods[METHOD_getConditionForKeyStroke49] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getConditionForKeyStroke", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_getConditionForKeyStroke49].setDisplayName ( "" );
            methods[METHOD_getDefaultLocale50] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getDefaultLocale", new Class[] {})); // NOI18N
            methods[METHOD_getDefaultLocale50].setDisplayName ( "" );
            methods[METHOD_getFocusTraversalKeys51] = new MethodDescriptor(java.awt.Container.class.getMethod("getFocusTraversalKeys", new Class[] {int.class})); // NOI18N
            methods[METHOD_getFocusTraversalKeys51].setDisplayName ( "" );
            methods[METHOD_getFontMetrics52] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class})); // NOI18N
            methods[METHOD_getFontMetrics52].setDisplayName ( "" );
            methods[METHOD_getInsets53] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getInsets", new Class[] {java.awt.Insets.class})); // NOI18N
            methods[METHOD_getInsets53].setDisplayName ( "" );
            methods[METHOD_getListeners54] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getListeners", new Class[] {java.lang.Class.class})); // NOI18N
            methods[METHOD_getListeners54].setDisplayName ( "" );
            methods[METHOD_getLocation55] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getLocation", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getLocation55].setDisplayName ( "" );
            methods[METHOD_getMnemonic56] = new MethodDescriptor(javax.swing.AbstractButton.class.getMethod("getMnemonic", new Class[] {})); // NOI18N
            methods[METHOD_getMnemonic56].setDisplayName ( "" );
            methods[METHOD_getMousePosition57] = new MethodDescriptor(java.awt.Container.class.getMethod("getMousePosition", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_getMousePosition57].setDisplayName ( "" );
            methods[METHOD_getPopupLocation58] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getPopupLocation", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getPopupLocation58].setDisplayName ( "" );
            methods[METHOD_getPropertyChangeListeners59] = new MethodDescriptor(java.awt.Component.class.getMethod("getPropertyChangeListeners", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_getPropertyChangeListeners59].setDisplayName ( "" );
            methods[METHOD_getSerialversionuid60] = new MethodDescriptor(nuevoBoton.BotonMejorado.class.getMethod("getSerialversionuid", new Class[] {})); // NOI18N
            methods[METHOD_getSerialversionuid60].setDisplayName ( "" );
            methods[METHOD_getSize61] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getSize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_getSize61].setDisplayName ( "" );
            methods[METHOD_getToolTipLocation62] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getToolTipLocation", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getToolTipLocation62].setDisplayName ( "" );
            methods[METHOD_getToolTipText63] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getToolTipText", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getToolTipText63].setDisplayName ( "" );
            methods[METHOD_gotFocus64] = new MethodDescriptor(java.awt.Component.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_gotFocus64].setDisplayName ( "" );
            methods[METHOD_grabFocus65] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("grabFocus", new Class[] {})); // NOI18N
            methods[METHOD_grabFocus65].setDisplayName ( "" );
            methods[METHOD_handleEvent66] = new MethodDescriptor(java.awt.Component.class.getMethod("handleEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_handleEvent66].setDisplayName ( "" );
            methods[METHOD_hasFocus67] = new MethodDescriptor(java.awt.Component.class.getMethod("hasFocus", new Class[] {})); // NOI18N
            methods[METHOD_hasFocus67].setDisplayName ( "" );
            methods[METHOD_hide68] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("hide", new Class[] {})); // NOI18N
            methods[METHOD_hide68].setDisplayName ( "" );
            methods[METHOD_imageUpdate69] = new MethodDescriptor(javax.swing.AbstractButton.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, int.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_imageUpdate69].setDisplayName ( "" );
            methods[METHOD_insets70] = new MethodDescriptor(java.awt.Container.class.getMethod("insets", new Class[] {})); // NOI18N
            methods[METHOD_insets70].setDisplayName ( "" );
            methods[METHOD_inside71] = new MethodDescriptor(java.awt.Component.class.getMethod("inside", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_inside71].setDisplayName ( "" );
            methods[METHOD_invalidate72] = new MethodDescriptor(java.awt.Container.class.getMethod("invalidate", new Class[] {})); // NOI18N
            methods[METHOD_invalidate72].setDisplayName ( "" );
            methods[METHOD_isAncestorOf73] = new MethodDescriptor(java.awt.Container.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isAncestorOf73].setDisplayName ( "" );
            methods[METHOD_isFocusCycleRoot74] = new MethodDescriptor(java.awt.Container.class.getMethod("isFocusCycleRoot", new Class[] {java.awt.Container.class})); // NOI18N
            methods[METHOD_isFocusCycleRoot74].setDisplayName ( "" );
            methods[METHOD_isLightweightComponent75] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("isLightweightComponent", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isLightweightComponent75].setDisplayName ( "" );
            methods[METHOD_keyDown76] = new MethodDescriptor(java.awt.Component.class.getMethod("keyDown", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyDown76].setDisplayName ( "" );
            methods[METHOD_keyUp77] = new MethodDescriptor(java.awt.Component.class.getMethod("keyUp", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyUp77].setDisplayName ( "" );
            methods[METHOD_layout78] = new MethodDescriptor(java.awt.Container.class.getMethod("layout", new Class[] {})); // NOI18N
            methods[METHOD_layout78].setDisplayName ( "" );
            methods[METHOD_list79] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {})); // NOI18N
            methods[METHOD_list79].setDisplayName ( "" );
            methods[METHOD_list80] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintStream.class})); // NOI18N
            methods[METHOD_list80].setDisplayName ( "" );
            methods[METHOD_list81] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintWriter.class})); // NOI18N
            methods[METHOD_list81].setDisplayName ( "" );
            methods[METHOD_list82] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintStream.class, int.class})); // NOI18N
            methods[METHOD_list82].setDisplayName ( "" );
            methods[METHOD_list83] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintWriter.class, int.class})); // NOI18N
            methods[METHOD_list83].setDisplayName ( "" );
            methods[METHOD_locate84] = new MethodDescriptor(java.awt.Container.class.getMethod("locate", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_locate84].setDisplayName ( "" );
            methods[METHOD_location85] = new MethodDescriptor(java.awt.Component.class.getMethod("location", new Class[] {})); // NOI18N
            methods[METHOD_location85].setDisplayName ( "" );
            methods[METHOD_lostFocus86] = new MethodDescriptor(java.awt.Component.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_lostFocus86].setDisplayName ( "" );
            methods[METHOD_minimumSize87] = new MethodDescriptor(java.awt.Container.class.getMethod("minimumSize", new Class[] {})); // NOI18N
            methods[METHOD_minimumSize87].setDisplayName ( "" );
            methods[METHOD_mouseDown88] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDown88].setDisplayName ( "" );
            methods[METHOD_mouseDrag89] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDrag89].setDisplayName ( "" );
            methods[METHOD_mouseEnter90] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseEnter90].setDisplayName ( "" );
            methods[METHOD_mouseExit91] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseExit91].setDisplayName ( "" );
            methods[METHOD_mouseMove92] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseMove92].setDisplayName ( "" );
            methods[METHOD_mouseUp93] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseUp93].setDisplayName ( "" );
            methods[METHOD_move94] = new MethodDescriptor(java.awt.Component.class.getMethod("move", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_move94].setDisplayName ( "" );
            methods[METHOD_nextFocus95] = new MethodDescriptor(java.awt.Component.class.getMethod("nextFocus", new Class[] {})); // NOI18N
            methods[METHOD_nextFocus95].setDisplayName ( "" );
            methods[METHOD_paint96] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paint", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paint96].setDisplayName ( "" );
            methods[METHOD_paintAll97] = new MethodDescriptor(java.awt.Component.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintAll97].setDisplayName ( "" );
            methods[METHOD_paintComponents98] = new MethodDescriptor(java.awt.Container.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintComponents98].setDisplayName ( "" );
            methods[METHOD_paintImmediately99] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paintImmediately", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_paintImmediately99].setDisplayName ( "" );
            methods[METHOD_paintImmediately100] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paintImmediately", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_paintImmediately100].setDisplayName ( "" );
            methods[METHOD_postEvent101] = new MethodDescriptor(java.awt.Component.class.getMethod("postEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_postEvent101].setDisplayName ( "" );
            methods[METHOD_preferredSize102] = new MethodDescriptor(java.awt.Container.class.getMethod("preferredSize", new Class[] {})); // NOI18N
            methods[METHOD_preferredSize102].setDisplayName ( "" );
            methods[METHOD_prepareImage103] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage103].setDisplayName ( "" );
            methods[METHOD_prepareImage104] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage104].setDisplayName ( "" );
            methods[METHOD_print105] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("print", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_print105].setDisplayName ( "" );
            methods[METHOD_printAll106] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("printAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printAll106].setDisplayName ( "" );
            methods[METHOD_printComponents107] = new MethodDescriptor(java.awt.Container.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printComponents107].setDisplayName ( "" );
            methods[METHOD_putClientProperty108] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("putClientProperty", new Class[] {java.lang.Object.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_putClientProperty108].setDisplayName ( "" );
            methods[METHOD_registerKeyboardAction109] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, java.lang.String.class, javax.swing.KeyStroke.class, int.class})); // NOI18N
            methods[METHOD_registerKeyboardAction109].setDisplayName ( "" );
            methods[METHOD_registerKeyboardAction110] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, javax.swing.KeyStroke.class, int.class})); // NOI18N
            methods[METHOD_registerKeyboardAction110].setDisplayName ( "" );
            methods[METHOD_remove111] = new MethodDescriptor(java.awt.Component.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class})); // NOI18N
            methods[METHOD_remove111].setDisplayName ( "" );
            methods[METHOD_remove112] = new MethodDescriptor(java.awt.Container.class.getMethod("remove", new Class[] {int.class})); // NOI18N
            methods[METHOD_remove112].setDisplayName ( "" );
            methods[METHOD_remove113] = new MethodDescriptor(java.awt.Container.class.getMethod("remove", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_remove113].setDisplayName ( "" );
            methods[METHOD_removeAll114] = new MethodDescriptor(java.awt.Container.class.getMethod("removeAll", new Class[] {})); // NOI18N
            methods[METHOD_removeAll114].setDisplayName ( "" );
            methods[METHOD_removeNotify115] = new MethodDescriptor(javax.swing.JButton.class.getMethod("removeNotify", new Class[] {})); // NOI18N
            methods[METHOD_removeNotify115].setDisplayName ( "" );
            methods[METHOD_removePropertyChangeListener116] = new MethodDescriptor(java.awt.Component.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_removePropertyChangeListener116].setDisplayName ( "" );
            methods[METHOD_repaint117] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {})); // NOI18N
            methods[METHOD_repaint117].setDisplayName ( "" );
            methods[METHOD_repaint118] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {long.class})); // NOI18N
            methods[METHOD_repaint118].setDisplayName ( "" );
            methods[METHOD_repaint119] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint119].setDisplayName ( "" );
            methods[METHOD_repaint120] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("repaint", new Class[] {long.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint120].setDisplayName ( "" );
            methods[METHOD_repaint121] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("repaint", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_repaint121].setDisplayName ( "" );
            methods[METHOD_requestDefaultFocus122] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestDefaultFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestDefaultFocus122].setDisplayName ( "" );
            methods[METHOD_requestFocus123] = new MethodDescriptor(java.awt.Component.class.getMethod("requestFocus", new Class[] {java.awt.event.FocusEvent.Cause.class})); // NOI18N
            methods[METHOD_requestFocus123].setDisplayName ( "" );
            methods[METHOD_requestFocus124] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestFocus124].setDisplayName ( "" );
            methods[METHOD_requestFocus125] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocus", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_requestFocus125].setDisplayName ( "" );
            methods[METHOD_requestFocusInWindow126] = new MethodDescriptor(java.awt.Component.class.getMethod("requestFocusInWindow", new Class[] {java.awt.event.FocusEvent.Cause.class})); // NOI18N
            methods[METHOD_requestFocusInWindow126].setDisplayName ( "" );
            methods[METHOD_requestFocusInWindow127] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocusInWindow", new Class[] {})); // NOI18N
            methods[METHOD_requestFocusInWindow127].setDisplayName ( "" );
            methods[METHOD_resetKeyboardActions128] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("resetKeyboardActions", new Class[] {})); // NOI18N
            methods[METHOD_resetKeyboardActions128].setDisplayName ( "" );
            methods[METHOD_reshape129] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("reshape", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_reshape129].setDisplayName ( "" );
            methods[METHOD_resize130] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_resize130].setDisplayName ( "" );
            methods[METHOD_resize131] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_resize131].setDisplayName ( "" );
            methods[METHOD_revalidate132] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("revalidate", new Class[] {})); // NOI18N
            methods[METHOD_revalidate132].setDisplayName ( "" );
            methods[METHOD_scrollRectToVisible133] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("scrollRectToVisible", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_scrollRectToVisible133].setDisplayName ( "" );
            methods[METHOD_setBounds134] = new MethodDescriptor(java.awt.Component.class.getMethod("setBounds", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_setBounds134].setDisplayName ( "" );
            methods[METHOD_setComponentZOrder135] = new MethodDescriptor(java.awt.Container.class.getMethod("setComponentZOrder", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_setComponentZOrder135].setDisplayName ( "" );
            methods[METHOD_setDefaultLocale136] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("setDefaultLocale", new Class[] {java.util.Locale.class})); // NOI18N
            methods[METHOD_setDefaultLocale136].setDisplayName ( "" );
            methods[METHOD_setMnemonic137] = new MethodDescriptor(javax.swing.AbstractButton.class.getMethod("setMnemonic", new Class[] {int.class})); // NOI18N
            methods[METHOD_setMnemonic137].setDisplayName ( "" );
            methods[METHOD_show138] = new MethodDescriptor(java.awt.Component.class.getMethod("show", new Class[] {})); // NOI18N
            methods[METHOD_show138].setDisplayName ( "" );
            methods[METHOD_show139] = new MethodDescriptor(java.awt.Component.class.getMethod("show", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_show139].setDisplayName ( "" );
            methods[METHOD_size140] = new MethodDescriptor(java.awt.Component.class.getMethod("size", new Class[] {})); // NOI18N
            methods[METHOD_size140].setDisplayName ( "" );
            methods[METHOD_toString141] = new MethodDescriptor(java.awt.Component.class.getMethod("toString", new Class[] {})); // NOI18N
            methods[METHOD_toString141].setDisplayName ( "" );
            methods[METHOD_transferFocus142] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocus", new Class[] {})); // NOI18N
            methods[METHOD_transferFocus142].setDisplayName ( "" );
            methods[METHOD_transferFocusBackward143] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusBackward", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusBackward143].setDisplayName ( "" );
            methods[METHOD_transferFocusDownCycle144] = new MethodDescriptor(java.awt.Container.class.getMethod("transferFocusDownCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusDownCycle144].setDisplayName ( "" );
            methods[METHOD_transferFocusUpCycle145] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusUpCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusUpCycle145].setDisplayName ( "" );
            methods[METHOD_unregisterKeyboardAction146] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("unregisterKeyboardAction", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_unregisterKeyboardAction146].setDisplayName ( "" );
            methods[METHOD_update147] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("update", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_update147].setDisplayName ( "" );
            methods[METHOD_updateUI148] = new MethodDescriptor(javax.swing.JButton.class.getMethod("updateUI", new Class[] {})); // NOI18N
            methods[METHOD_updateUI148].setDisplayName ( "" );
            methods[METHOD_validate149] = new MethodDescriptor(java.awt.Container.class.getMethod("validate", new Class[] {})); // NOI18N
            methods[METHOD_validate149].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods
        // Here you can add code for customizing the methods array.

        return methods;     }//GEN-LAST:Methods

    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons

    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx


//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.

//GEN-LAST:Superclass
    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable properties of this bean.
     * May return null if the information should be obtained by automatic
     * analysis.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }

    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean. May return null if the information
     * should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will belong
     * to the IndexedPropertyDescriptor subclass of PropertyDescriptor. A client
     * of getPropertyDescriptors can use "instanceof" to check if a given
     * PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }

    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     *
     * @return An array of EventSetDescriptors describing the kinds of events
     * fired by this bean. May return null if the information should be obtained
     * by automatic analysis.
     */
    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }

    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     *
     * @return An array of MethodDescriptors describing the methods implemented
     * by this bean. May return null if the information should be obtained by
     * automatic analysis.
     */
    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     *
     * @return Index of default property in the PropertyDescriptor array
     * returned by getPropertyDescriptors.
     * <P>
     * Returns -1 if there is no default property.
     */
    @Override
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will mostly
     * commonly be used by human's when using the bean.
     *
     * @return Index of default event in the EventSetDescriptor array returned
     * by getEventSetDescriptors.
     * <P>
     * Returns -1 if there is no default event.
     */
    @Override
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }

    /**
     * This method returns an image object that can be used to represent the
     * bean in toolboxes, toolbars, etc. Icon images will typically be GIFs, but
     * may in future include other formats.
     * <p>
     * Beans aren't required to provide icons and may return null from this
     * method.
     * <p>
     * There are four possible flavors of icons (16x16 color, 32x32 color, 16x16
     * mono, 32x32 mono). If a bean choses to only support a single icon we
     * recommend supporting 16x16 color.
     * <p>
     * We recommend that icons have a "transparent" background so they can be
     * rendered onto an existing background.
     *
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon. May return null
     * if no suitable icon is available.
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_COLOR_16x16:
                if (iconNameC16 == null) {
                    return null;
                } else {
                    if (iconColor16 == null) {
                        iconColor16 = loadImage(iconNameC16);
                    }
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if (iconNameC32 == null) {
                    return null;
                } else {
                    if (iconColor32 == null) {
                        iconColor32 = loadImage(iconNameC32);
                    }
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if (iconNameM16 == null) {
                    return null;
                } else {
                    if (iconMono16 == null) {
                        iconMono16 = loadImage(iconNameM16);
                    }
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if (iconNameM32 == null) {
                    return null;
                } else {
                    if (iconMono32 == null) {
                        iconMono32 = loadImage(iconNameM32);
                    }
                    return iconMono32;
                }
            default:
                return null;
        }
    }
    
}
