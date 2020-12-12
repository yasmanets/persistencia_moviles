//
//  ViewController.swift
//  NotasCoreData
//
//  Created by Yaser  on 12/12/2020.
//  Copyright © 2020 Yaser . All rights reserved.
//

import UIKit
import CoreData

class ViewController: UIViewController {

    @IBOutlet weak var noteTextView: UITextView!
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var messageLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.noteTextView.text = "Introduce el texto de la nota"
        self.dateLabel.text = ""
        self.messageLabel.text = ""
    }

    @IBAction func saveNote(_ sender: Any) {
        guard let coreDelegate = UIApplication.shared.delegate as? AppDelegate else{
            return
        }
        let myContext = coreDelegate.persistentContainer.viewContext
        let note = Nota(context: myContext)
        note.fecha = Date()
        note.texto = self.noteTextView.text
        
        do {
            try myContext.save()
            self.dateLabel.text = DateFormatter.localizedString(from: note.fecha!, dateStyle: .short, timeStyle: .medium)
            self.messageLabel.text = "Nota guardada con éxito!"

        } catch {
            print("Error al guardar el contexto: \(error)")
        }
    }
    
    @IBAction func createNewNote(_ sender: Any) {
        self.noteTextView.text = ""
        self.dateLabel.text = ""
        self.messageLabel.text = ""
    }
}

